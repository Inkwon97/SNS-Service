package com.project.snsservice.global.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    USER_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "유저를 찾을 수 없습니다."),
    ALREADY_REGISTER_USER(HttpStatus.CONFLICT, "유저가 존재합니다.")
    ;

    private HttpStatus httpStatus;
    private String message;

    ErrorCode(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
