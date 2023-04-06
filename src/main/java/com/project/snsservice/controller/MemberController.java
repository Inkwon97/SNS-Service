package com.project.snsservice.controller;

import com.project.snsservice.chat.controller.response.ResponseDto;
import com.project.snsservice.doamin.response.MemberDto;
import com.project.snsservice.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
@RestController
public class MemberController {

    private final MemberService memberService;

    // 회원가입
    @PostMapping("/signup")
    public ResponseDto<MemberDto> signUpUser(@Valid @RequestBody MemberDto memberDto) {
        log.info("nickname : {}, username : {}", memberDto.getNickname(), memberDto.getUsername());
        return memberService.signUpUser(memberDto);
    }

}
