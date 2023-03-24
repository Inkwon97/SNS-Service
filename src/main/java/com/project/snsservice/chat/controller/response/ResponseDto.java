package com.project.snsservice.chat.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseDto<T> {
    private String resultCode;
    private T result;

    public static <T> ResponseDto<T> success() {
        return new ResponseDto<>("SUCCESS", null);
    }

    public static <T> ResponseDto<T> success(T result) {
        return new ResponseDto<>("SUCCESS", result);
    }

    public static <T> ResponseDto<T> error(String resultCode) {
        return new ResponseDto<>(resultCode, null);
    }
    public static <T> ResponseDto<T> error(String resultCode, T message) {
        return new ResponseDto<>(resultCode, message);
    }
}
