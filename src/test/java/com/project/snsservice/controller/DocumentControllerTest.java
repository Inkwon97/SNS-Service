package com.project.snsservice.controller;

import com.project.snsservice.security.config.JwtSecurityConfig;
import com.project.snsservice.security.config.SecurityConfig;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Disabled
@Import({SecurityConfig.class, JwtSecurityConfig.class})
@WebMvcTest(DocumentController.class)
class DocumentControllerTest {

    private final MockMvc mvc;

    public DocumentControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @Test
    public void 컨트롤러_테스트() throws Exception {
        //given

        //when
        mvc.perform(get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());

        //then
    }

}