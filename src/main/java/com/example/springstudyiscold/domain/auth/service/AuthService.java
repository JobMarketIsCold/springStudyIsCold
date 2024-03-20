package com.example.springstudyiscold.domain.auth.service;

import com.example.springstudyiscold.domain.auth.presentation.dto.CreateUserDto;
import com.example.springstudyiscold.domain.auth.presentation.dto.LoginUserDto;
import com.example.springstudyiscold.domain.user.domain.User;
import com.example.springstudyiscold.domain.user.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    @Transactional
    public User signup(CreateUserDto createUserDto) {
        User duplicate = userRepository.findByUserId(createUserDto.userId());
        System.out.println(duplicate);
        if(duplicate == null) {
            // Bcrypt compare 적용할 부분
            return userRepository.save(createUserDto.toEntity());
        };
        throw new DuplicateKeyException("유저 존재");
    }
    @Transactional(readOnly = true)
    public User login(LoginUserDto loginUserDto) {
        User findUser = userRepository.findByUserId(loginUserDto.userId()); // 나중에 bcrypt 적용하고 existByUserId로 고치자
        // bcrypt 부분(만약에 비밀번호가 맞다면)
        return findUser;
    }
}
