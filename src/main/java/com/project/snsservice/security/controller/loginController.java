package com.project.snsservice.security.controller;

import com.project.snsservice.security.dto.UserDto;
import com.project.snsservice.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class loginController {

    private final UserService userService;

    @GetMapping("/user")
    public UserDto my(Authentication authentication) {
        UserDto userDto = UserDto.of(authentication.getName(), "test");
        return userService.myPage(userDto);
    }
}
