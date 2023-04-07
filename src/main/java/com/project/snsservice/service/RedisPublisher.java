package com.project.snsservice.service;

import com.project.snsservice.doamin.ChatMessage;
import com.project.snsservice.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class RedisPublisher {

    private final RedisTemplate<String, ChatMessage> redisTemplate;
    private final ChatRoomService chatRoomService;

    public void publish(ChannelTopic topic, ChatMessage message) {
        log.info("topic {}, message {}", topic.getTopic(), message.getMessage());
        redisTemplate.convertAndSend(topic.getTopic(), message);
        chatRoomService.saveChat(topic, message);
    }
}
