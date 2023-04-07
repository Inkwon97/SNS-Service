package com.project.snsservice.doamin.dto;


import com.project.snsservice.doamin.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberLoginDto {
    private String username;
    private String password;

    private MemberLoginDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static MemberLoginDto of(String username, String password) {
        return new MemberLoginDto(username, password);
    }


}
