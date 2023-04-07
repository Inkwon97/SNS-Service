package com.project.snsservice.controller;

import com.project.snsservice.chat.controller.response.ResponseDto;
import com.project.snsservice.doamin.dto.MemberLoginDto;
import com.project.snsservice.doamin.dto.MemberSignUpDto;
import com.project.snsservice.global.exception.CustomException;
import com.project.snsservice.global.exception.ErrorCode;
import com.project.snsservice.security.dto.TokenDto;
import com.project.snsservice.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
@RestController
public class MemberController {

    private final MemberService memberService;

    // 회원가입
    @PostMapping("/signUp")
    public ResponseDto<MemberSignUpDto> signUpUser(@Valid @RequestBody MemberSignUpDto memberSignUpDto) {
        log.info("nickname : {}, username : {}", memberSignUpDto.getNickname(), memberSignUpDto.getUsername());
        return memberService.signUpUser(memberSignUpDto);
    }

    @PostMapping("/signIn")
    public ResponseDto<?> signIn(@Valid @RequestBody MemberLoginDto memberLoginDto, HttpServletResponse res) {
        ResponseEntity<TokenDto> tokenDtoResponseEntity = memberService.signIn(memberLoginDto);
        Cookie cookie = new Cookie(
                "access_token",
                tokenDtoResponseEntity.getBody().getAccess_token()
        );

        cookie.setPath("/");
        cookie.setMaxAge(Integer.MAX_VALUE);

        res.addCookie(cookie);
        return ResponseDto.success();
    }

    @GetMapping("/profile")
    public ResponseDto<MemberSignUpDto> profile(@AuthenticationPrincipal UserDetails userDetails) {
        log.info("method : Get, /user/profile, username : {}", userDetails.getUsername());
        if (userDetails == null) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND_EXCEPTION);
        }
        return memberService.getProfile(userDetails.getUsername());
    }
}
