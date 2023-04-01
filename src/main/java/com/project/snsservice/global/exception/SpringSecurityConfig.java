package com.project.snsservice.global.exception;

import com.project.snsservice.security.domain.User;
import com.project.snsservice.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@RequiredArgsConstructor
public class SpringSecurityConfig {

    private final UserService userService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/post").hasRole("USER")
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers(
                        "/chat/**",
                        "/ws-stomp/**",
                        "/pub/**",
                        "/sub/**",
                        "/chat/**"
                ).permitAll()
                .anyRequest().authenticated();

        http.formLogin();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            return userService.findByUsername(username);
        };
    }
}
