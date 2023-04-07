package com.project.snsservice.doamin.dto;

import com.project.snsservice.doamin.Member;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class MemberSignUpDto {

    @NotNull
    private String username;
    @NotNull
    private String nickname;
    @NotNull
    private String password;
    private String profileImg;

    public MemberSignUpDto(String username, String nickname, String password, String profileImg) {
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.profileImg = profileImg;
    }

    public static MemberSignUpDto of(String username, String nickname, String password, String profileImg) {
        return new MemberSignUpDto(username, nickname, password, profileImg);
    }

    public static MemberSignUpDto fromEntity(Member member) {
        return new MemberSignUpDto(
                member.getUsername(),
                member.getNickname(),
                member.getPassword(),
                member.getProfileImg());
    }

    public Member toEntity() {
        return Member.of(getUsername(), getNickname(), getPassword(), getProfileImg());
    }

    public static MemberSignUpDto responseDto(Member member) {
        return new MemberSignUpDto(
                member.getUsername(),
                member.getNickname(),
                null,
                member.getProfileImg());
    }
}