package com.example.springstudyiscold.domain.auth.presentation.dto;

import com.example.springstudyiscold.domain.user.domain.User;

import static com.example.springstudyiscold.domain.user.domain.type.Role.USER;

public record CreateUserDto (
    String userId,
    String userPassword,
    String nickname

){
    public User toEntity() {
        return User.builder()
                .userId(this.userId)
                .userPassword(this.userPassword)
                .nickname(this.nickname)
                .role(USER)
                .build();
    }
}
