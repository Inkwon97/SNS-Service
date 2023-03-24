package com.project.snsservice.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    CHATROOM_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 방이 존재하지 않습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
