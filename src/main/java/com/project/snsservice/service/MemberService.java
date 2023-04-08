package com.project.snsservice.service;

import com.project.snsservice.doamin.dto.ResponseDto;
import com.project.snsservice.doamin.Member;
import com.project.snsservice.doamin.dto.MemberLoginDto;
import com.project.snsservice.doamin.dto.MemberSignUpDto;
import com.project.snsservice.global.exception.CustomException;
import com.project.snsservice.global.exception.ErrorCode;
import com.project.snsservice.repository.MemberRepository;
import com.project.snsservice.security.dto.TokenDto;
import com.project.snsservice.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Slf4j
@Transactional
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    public ResponseDto<MemberSignUpDto> signUpMember(MemberSignUpDto memberSignUpDto) {
        log.info("{}", memberSignUpDto.getUsername());

        if (memberRepository.findByUsername(memberSignUpDto.getUsername()).isPresent()) {
            throw new CustomException(ErrorCode.USER_ALREADY_EXISTED);
        }

        // 1. DTO를 Entity로 변환
        // 2. 패스워드 암호 후, 해당 Entity를 save
        Member member = memberSignUpDto.toEntity();
        member = member.hashPassword(bCryptPasswordEncoder);
        Member savedMember = memberRepository.save(member);
        return ResponseDto.success(MemberSignUpDto.responseDto(savedMember));
    }

    public ResponseEntity<TokenDto> signInMember(MemberLoginDto memberLoginDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            memberLoginDto.getUsername(),
                            memberLoginDto.getPassword()
                    )
            );

            TokenDto tokenDto = new TokenDto(jwtTokenProvider.generateToken(authentication));

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", "Bearer " + tokenDto.getAccess_token());

            return new ResponseEntity<>(tokenDto, httpHeaders, HttpStatus.OK);
        } catch (AuthenticationException e) {
            throw new CustomException(ErrorCode.INVALID_CREDENTIALS_SUPPLIED);
        }
    }

    // UserName으로 멤버를 반환
    @Transactional(readOnly = true)
    public ResponseDto<MemberSignUpDto> getMember(String username) {
        Member member = memberRepository.findByUsername(username).orElseThrow(
                () -> new CustomException(ErrorCode.USER_NOT_FOUND_EXCEPTION)
        );

        MemberSignUpDto responseDto = MemberSignUpDto.responseDto(member);
        return ResponseDto.success(responseDto);
    }

}