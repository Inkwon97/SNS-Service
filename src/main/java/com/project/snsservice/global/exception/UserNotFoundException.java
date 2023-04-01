package com.project.snsservice.global.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends RuntimeException{

    private HttpStatus httpStatus;

    public UserNotFoundException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        httpStatus = errorCode.getHttpStatus();
    }
}
