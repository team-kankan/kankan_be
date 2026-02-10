package com.teamkankan.kankan.user.controller;

import com.teamkankan.kankan.common.response.ApiResponse;
import com.teamkankan.kankan.user.dto.SignupRequest;
import com.teamkankan.kankan.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> signup(@Valid @RequestBody SignupRequest request) {
        userService.signup(request);

        return ResponseEntity.ok(
                new ApiResponse("회원가입 성공", null)
        );
    }
}
