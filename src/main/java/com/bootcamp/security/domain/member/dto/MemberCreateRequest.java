package com.bootcamp.security.domain.member.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MemberCreateRequest(
        @NotNull(message = "이름은 필수입니다.") String name,
        @NotNull(message = "Id는 필수입니다.") String username,
        @NotNull @Pattern(
                regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$",
                message = "비밀번호는 8자 이상, 영문/숫자/특수문자를 포함해야 합니다"
        ) String password
) {
}
