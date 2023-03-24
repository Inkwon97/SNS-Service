package com.project.snsservice.chat.repository;

import com.project.snsservice.chat.domain.Chat;
import com.project.snsservice.chat.domain.ChatMessage;
import com.project.snsservice.chat.domain.ChatRoom;
import com.project.snsservice.chat.service.RedisSubscriber;
import com.project.snsservice.global.exception.CustomException;
import com.project.snsservice.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChatRoomService {
    // 채팅방(topic)에 발행되는 메시지를 처리할 Listner
    private final RedisMessageListenerContainer redisMessageListener;
    // 구독 처리 서비스
    private final RedisSubscriber redisSubscriber;
    // Redis
    private static final String CHAT_ROOMS = "CHAT_ROOM";
    private static final String CHAT = "CHAT";
    private final RedisTemplate<String, ChatRoom> redisTemplate;
    private final RedisTemplate<String, Chat> redisChatTemplate;

    // 채팅방의 대화 메시지를 발행하기 위한 redis topic 정보. 서버별로 채팅방에 매치되는 topic정보를 Map에 넣어 roomId로 찾을수 있도록 한다.
    private Map<String, ChannelTopic> topics;

    private final ChatRoomRepository chatRoomRepository;

    @PostConstruct
    private void init() {
        topics = new HashMap<>();
    }

    public List<Object> findAllRoom() {
        return redisTemplate.opsForHash().values(CHAT_ROOMS);
    }

    /**
    * redis에 채팅방이 있는지 확인 후, 없다면 Repository에서 데이터를 가져오도록 하였음
    */
    public ChatRoom findRoomById(Long roomId) {
        ChatRoom chatRoom = (ChatRoom) redisTemplate.opsForHash().get(CHAT_ROOMS, String.valueOf(roomId));
        if (chatRoom == null) {
            return chatRoomRepository.findById(roomId).orElseThrow(() -> new CustomException(ErrorCode.CHATROOM_NOT_FOUND));
        }
        return (ChatRoom) chatRoom;
    }


    /**
     * 채팅방 생성 : 서버간 채팅방 공유를 위해 redis hash에 저장한다.
     */
    public ChatRoom createChatRoom(String name) {
        ChatRoom chatRoom = ChatRoom.create(name); // TODO: Map은 순서없이 저장되므로 이후에 ID를 자동생성해서 roomId에 넣어주기
        ChatRoom savedChatRoom = chatRoomRepository.save(chatRoom);
        redisTemplate.opsForHash().put(CHAT_ROOMS, String.valueOf(savedChatRoom.getRoomId()), chatRoom);
        log.info("createChatRoom id : {} name : {}", savedChatRoom.getRoomId(), chatRoom.getName());
        return chatRoom;
    }

    /**
     * 채팅방 입장 : redis에 topic을 만들고 pub/sub 통신을 하기 위해 리스너를 설정한다.
     */
    public void enterChatRoom(String roomId) {
        ChannelTopic topic = topics.get(roomId);
        if (topic == null)
            topic = new ChannelTopic(roomId);
        redisMessageListener.addMessageListener(redisSubscriber, topic);
        topics.put(roomId, topic);
    }

    public void saveChat(ChannelTopic topic, ChatMessage message) {
        // TODO: KEY값과 subkey가 모두 동일하면 안된다. message의 ID별로 넣어줄 것
        log.info("CHAT : {} TOPIC : {} MESSAGE : {}", CHAT, topic.getTopic(), message.getMessage());
        Chat chat = Chat.of(message);
        redisChatTemplate.opsForHash().put(CHAT, topic.getTopic(), chat);
    }

    public ChannelTopic getTopic(String roomId) {
        return topics.get(roomId);
    }
}