package com.project.snsservice.doamin.response;

import com.project.snsservice.doamin.Member;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MemberDto {

    @NotNull
    private String username;
    @NotNull
    private String nickname;
    @NotNull
    private String password;
    private String profileImg;

    private MemberDto(String nickname, String username, String profileImg) {
        this.nickname = nickname;
        this.username = username;
        this.profileImg = profileImg;
    }

    public static MemberDto of(String nickname, String username, String profileImg) {
        return new MemberDto(nickname, username, profileImg);
    }

    public static MemberDto from(Member member) {
        return new MemberDto(member.getNickname(), member.getUsername(), member.getProfileImg());
    }

    public Member to() {
        return Member.of(nickname, username, password, profileImg);
    }
}