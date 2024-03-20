package com.example.springstudyiscold.domain.user.repository;

import com.example.springstudyiscold.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(String userId);

    User existsByUserId(String userId);
}
