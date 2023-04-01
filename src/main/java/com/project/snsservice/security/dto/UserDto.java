package com.project.snsservice.security.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserDto {

    private String username;
    private String password;

    private UserDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static UserDto of(String username, String password) {
        return new UserDto(username, password);
    }
}
