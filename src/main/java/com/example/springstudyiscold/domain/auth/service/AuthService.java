package com.example.springstudyiscold.domain.auth.service;

import com.example.springstudyiscold.domain.auth.presentation.dto.CreateUserDto;
import com.example.springstudyiscold.domain.auth.presentation.dto.LoginUserDto;
import com.example.springstudyiscold.domain.user.domain.User;
import com.example.springstudyiscold.domain.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Transactional
    public Optional<User> signup(CreateUserDto createUserDto) {
        User duplicate = userRepository.findByUserId(createUserDto.userId());
        if(duplicate == null) {
            return Optional.of(userRepository.save(User.builder()
                    .userId(createUserDto.userId())
                    .userPassword(bCryptPasswordEncoder.encode(createUserDto.getPassword()))
                    .nickname(createUserDto.nickname())
                    .build()
            ));
            // return userRepository.save(createUserDto.toEntity());
        };
        throw new DuplicateKeyException("유저 존재");
    }
    @Transactional(readOnly = true)
    public User login(LoginUserDto loginUserDto) {
        User findUser = userRepository.findByUserId(loginUserDto.userId()); // 나중에 bcrypt 적용하고 existByUserId로 고치자
        if(findUser == null) throw new UsernameNotFoundException("로그인 실패");
        boolean matchPassword = bCryptPasswordEncoder.matches(loginUserDto.userPassword(), findUser.getUserPassword());
        if(matchPassword) return findUser; // JWT적용하기
        throw new UsernameNotFoundException("로그인 실패");
    }
}
