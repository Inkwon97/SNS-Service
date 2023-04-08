package com.project.snsservice.doamin.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class DocumentDto {

    private String createdBy; // 작성자
    private LocalDateTime createdAt; // 작성 일자
    private String title; // 제목
    private String content; // 본문
    private String hashtag;

    public DocumentDto(String createdBy, LocalDateTime createdAt, String title, String content, String hashtag) {
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }

    public static DocumentDto of(String createdBy, LocalDateTime createdAt, String title, String content, String hashtag) {
        return new DocumentDto(createdBy, createdAt, title, content, hashtag);
    }

    public static DocumentDto of(String title, String content, String hashtag) {
        return new DocumentDto(null, null, title, content, hashtag);
    }
}
