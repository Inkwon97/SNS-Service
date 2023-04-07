package com.project.snsservice.doamin.dto;

import com.project.snsservice.doamin.Member;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    private MemberSignUpDto(String nickname, String username, String profileImg) {
        this.nickname = nickname;
        this.username = username;
        this.profileImg = profileImg;
    }

    public static MemberSignUpDto of(String nickname, String username, String profileImg) {
        return new MemberSignUpDto(nickname, username, profileImg);
    }

    public static MemberSignUpDto fromEntity(Member member) {
        return new MemberSignUpDto(member.getNickname(), member.getUsername(), member.getProfileImg());
    }

    public Member toEntity() {
        return Member.of(nickname, username, password, profileImg);
    }
}