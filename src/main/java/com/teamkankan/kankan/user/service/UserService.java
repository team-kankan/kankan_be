package com.teamkankan.kankan.user.service;

import com.teamkankan.kankan.common.exception.CustomException;
import com.teamkankan.kankan.common.exception.ErrorCode;
import com.teamkankan.kankan.user.dto.SignupRequest;
import com.teamkankan.kankan.user.entity.UserEntity;
import com.teamkankan.kankan.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signup(SignupRequest request) {

        // 이메일 중복 체크
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new CustomException(ErrorCode.DUPLICATE_EMAIL);
        }
        // 엔티티 생성
        UserEntity user = new UserEntity(
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                request.getNickname()
        );

        userRepository.save(user);
        }
    }

