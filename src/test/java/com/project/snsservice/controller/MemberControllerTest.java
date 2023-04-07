package com.project.snsservice.controller;

import com.project.snsservice.doamin.Member;
import com.project.snsservice.security.config.SecurityConfig;
import com.project.snsservice.service.MemberService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("인증처리 테스트")
@Import(SecurityConfig.class)
@WebMvcTest(MemberController.class)
class MemberControllerTest {

    private final MockMvc mvc;

    @MockBean
    private MemberService memberService;

    public MemberControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[view][GET]로그인 페이지 - 정상 호출")
    @Test
    public void 정상호출된_로그인_페이지() throws Exception {
        //given
        Member member = Member.of("ingwon", "ingwon123", "password", null);

        //when
        mvc.perform(get("/user/signUp"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        //then
        then(memberService).shouldHaveNoInteractions();
    }

    @TestComponent
    static class EmptyController {
    }

}