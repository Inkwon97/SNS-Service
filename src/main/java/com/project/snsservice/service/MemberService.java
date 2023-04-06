package com.project.snsservice.service;

import com.project.snsservice.chat.controller.response.ResponseDto;
import com.project.snsservice.doamin.Member;
import com.project.snsservice.doamin.response.MemberDto;
import com.project.snsservice.global.exception.CustomException;
import com.project.snsservice.global.exception.ErrorCode;
import com.project.snsservice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public ResponseDto<MemberDto> signUpUser(MemberDto memberDto) {

        if (memberRepository.findByUsername(memberDto.getUsername()).isPresent()) {
            throw new CustomException(ErrorCode.USER_ALREADY_EXISTED);
        }

        Member savedMember = memberRepository.save(memberDto.to());
        return ResponseDto.success(MemberDto.from(savedMember));
    }

    
}
