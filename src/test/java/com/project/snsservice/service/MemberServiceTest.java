package com.project.snsservice.service;

import com.project.snsservice.doamin.Member;
import com.project.snsservice.doamin.dto.MemberLoginDto;
import com.project.snsservice.doamin.dto.MemberSignUpDto;
import com.project.snsservice.doamin.dto.ResponseDto;
import com.project.snsservice.global.exception.CustomException;
import com.project.snsservice.repository.MemberRepository;
import com.project.snsservice.security.jwt.JwtTokenProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@DisplayName("비즈니스 로직 - 회원")
@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @InjectMocks
    private MemberService sut;

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtTokenProvider jwtTokenProvider;

    @DisplayName("존재하는 회원 ID를 검색하면, 회원 데이터를 Optional로 반환한다.")
    @Test
    void 존재하는_회원_검색() {
        //given
        String username = "ingwon";
        String nickname = "ingwon123";
        given(memberRepository.findByUsername(username)).willReturn(Optional.of(createMember(username, nickname)));

        //when
        ResponseDto<MemberSignUpDto> profile = sut.getMember(username);
        MemberSignUpDto result = profile.getResult();

        //then
        assertThat(result).isNotNull();
        then(memberRepository).should().findByUsername(username);
        System.out.println();
    }

    @DisplayName("존재하지 않는 회원을 검색하면, 비어있는 Optional을 반환한다")
    @Test
    public void 존재하지않는_회원_검색() throws Exception {
        //given
        String username = "wrong-user";
        given(memberRepository.findByUsername(username)).willReturn(Optional.empty());

        //when
        /*org.junit.jupiter.api.Assertions.assertThrows(CustomException.class, () -> {
            sut.getMember(username);
        });*/

        //then
        assertThatThrownBy(() -> sut.getMember(username)).isInstanceOf(CustomException.class);
        then(memberRepository).should().findByUsername(username);
    }

    @DisplayName("회원 정보를 입력하면, 새로운 회원 정보를 저장하여 가입시키고 해당 회원 데이터를 리턴시킨다")
    @Test
    public void 회원가입() throws Exception {
        //given
        Member member = createMember("ingwon", "ingwon123");
        Member savedMember = createSignUpMember("ingwon", "ingwon123");
        given(memberRepository.save(member)).willReturn(savedMember);

        //when
        MemberSignUpDto result = sut.signUpMember(MemberSignUpDto.fromEntity(member)).getResult();

        //then
        assertThat(result)
                .hasFieldOrPropertyWithValue("username", member.getUsername())
                .hasFieldOrPropertyWithValue("nickname", member.getNickname());

        then(memberRepository).should().save(member);
    }

    private Member createMember(String username, String nickname) {
        return Member.of(
                username,
                nickname,
                "password",
                null
        );
    }

    private Member createSignUpMember(String username, String nickname) {
        return createMember(username, nickname);
    }
}