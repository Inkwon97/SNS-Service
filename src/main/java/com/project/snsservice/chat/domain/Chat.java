package com.project.snsservice.chat.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sender;

    @Column(length = 100)
    private String message;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime sendDate;

    public Chat(ChatRoom chatRoom, String sender, String message) {
        new Chat(chatRoom, sender, message);
    }


}
