package com.example.springstudyiscold.domain.auth.presentation.dto;

import com.example.springstudyiscold.domain.user.domain.User;

public record LoginUserDto (
    String userId,

    String userPassword
){
    public User toEntity() {
        return User.builder()
                .userId(this.userId)
                .userPassword(this.userPassword)
                .build();
    }
}
