package com.example.springstudyiscold.domain.auth.presentation;

import com.example.springstudyiscold.domain.auth.presentation.dto.CreateUserDto;
import com.example.springstudyiscold.domain.auth.presentation.dto.LoginUserDto;
import com.example.springstudyiscold.domain.auth.service.AuthService;
import com.example.springstudyiscold.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public Optional<User> signup(@RequestBody CreateUserDto createUserDto){
        return authService.signup(createUserDto);
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginUserDto loginUserDto){
        return authService.login(loginUserDto);
    }
}
