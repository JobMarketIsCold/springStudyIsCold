package com.example.springstudyiscold.domain.user.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uid;

    @Column
    private String userId;

    @Column
    private String userPassword;

    @Column
    private String nickname;

}
