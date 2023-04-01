package com.project.snsservice.security.config;

import com.project.snsservice.security.domain.User;
import com.project.snsservice.security.dto.UserDto;
import com.project.snsservice.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class InitializeConfig {

    private final UserService userService;

    @Bean
    public void adminAccount() {
        userService.signUp(UserDto.of("user", "user"));
        userService.signUpAdmin(UserDto.of("admin", "admin"));
    }
}
