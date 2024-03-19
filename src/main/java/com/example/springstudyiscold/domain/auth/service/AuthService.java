package com.example.springstudyiscold.domain.auth.service;

import com.example.springstudyiscold.domain.auth.presentation.dto.CreateUserDto;
import com.example.springstudyiscold.domain.auth.presentation.dto.LoginUserDto;
import com.example.springstudyiscold.domain.user.domain.User;
import com.example.springstudyiscold.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    public User signup(CreateUserDto createUserDto) {
        User duplicate = userRepository.findByUserId(createUserDto.userId());
        System.out.println(duplicate);
        if(duplicate == null) {
            // Bcrypt compare 적용할 부분
            return userRepository.save(createUserDto.toEntity());
        };
        throw new DuplicateKeyException("유저 존재");
    }

    public User login(LoginUserDto loginUserDto) {
        User findUser = userRepository.findByUserId(loginUserDto.userId());
        // bcrypt 부분(만약에 비밀번호가 맞다면)
        return findUser; // 지금은 JWT는 너무 일러용.. security 설정이랑 bcrypt 먼저 해보고 할게용.
    }
}
