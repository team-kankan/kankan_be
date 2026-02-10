package com.teamkankan.kankan.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class SignupRequest {

    @NotBlank(message = "이메일은 필수입니다.")
    @Email(message = "올바른 이메일 형식이 아닙니다.")
    private String email;

    @NotBlank(message = "비밀번호는 필수입니다.")
    @Pattern(
        regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$",
        message = "영문, 숫자, 특수문자를 포함하여 8~20자로 입력해주세요."
    )
    private String password;

    @NotBlank(message = "닉네임은 필수입니다.")
    @Size(min = 2, max = 10, message = "닉네임은 2~10글자여야 합니다.")
    @Pattern(
        regexp = "^[a-zA-Z가-힣]+$",
        message = "닉네임은 한글 또는 영문만 가능합니다."
    )
    private String nickname;
}
