package com.project.snsservice.security.service;

import com.project.snsservice.global.exception.ErrorCode;
import com.project.snsservice.global.exception.UserNotFoundException;
import com.project.snsservice.security.domain.User;
import com.project.snsservice.security.dto.UserDto;
import com.project.snsservice.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public User signUp(UserDto userDto) {

        if (userRepository.findByUsername(userDto.getUsername()).isPresent()) {
            throw new UserNotFoundException(ErrorCode.ALREADY_REGISTER_USER);
        }

        return userRepository.save(User.UserOf(userDto.getUsername(), bCryptPasswordEncoder.encode(userDto.getPassword())));

    }

    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND_EXCEPTION)
        );
        return user;
    }

    public User signUpAdmin(UserDto userDto) {
        if (userRepository.findByUsername(userDto.getUsername()).isPresent()) {
            throw new UserNotFoundException(ErrorCode.USER_NOT_FOUND_EXCEPTION);
        }
        return userRepository.save(User.AdminOf(userDto.getUsername(), bCryptPasswordEncoder.encode(userDto.getPassword())));
    }

    public UserDto myPage(UserDto userDto) {
        return UserDto.of(userDto.getUsername(), "test");
    }
}
