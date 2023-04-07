package com.project.snsservice.doamin;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

//@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Chat implements Serializable {

/*    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;*/

    private String sender;

    @Column(length = 100)
    private String message;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime sendDate;

    public static Chat of(ChatMessage chatMessage) {
        return new Chat(chatMessage.getSender(), chatMessage.getMessage());
    }

    public Chat(String sender, String message) {
        this.sender = sender;
        this.message = message;
    }
}
