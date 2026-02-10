package com.teamkankan.kankan.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
@Getter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String password;

    @Column(length = 50, nullable = false)
    private String nickname;

    @Column(name = "kakao_id", unique = true)
    private String kakaoId;

    @Column(name = "social_provider",nullable = false)
    private String socialProvider;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    protected UserEntity() {
    }

    public UserEntity(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.socialProvider = "LOCAL";
        this.createdAt = LocalDateTime.now();
    }
}