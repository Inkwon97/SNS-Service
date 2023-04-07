package com.project.snsservice.global.exception;

import com.project.snsservice.doamin.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(CustomException.class)
    public ResponseDto<?> errorHandler(CustomException e) {
        log.error("Error occurs ErrorType : {}, ErrorCode : {}", e.toString(), e.getErrorCode());
        return ResponseDto.error(e.getErrorCode().name(), e.getMessage());
    }
}
