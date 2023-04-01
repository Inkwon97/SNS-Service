package com.project.snsservice.security.controller;

import com.project.snsservice.security.dto.UserDto;
import com.project.snsservice.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/signup")
@Controller
public class SignUpController {

    private final UserService userService;

    @GetMapping
    public String signUp() {
        return "signup";
    }

    @PostMapping
    public String signUp(@ModelAttribute UserDto userDto) {
        userService.signUp(userDto);
        return "redirect:login";
    }
}