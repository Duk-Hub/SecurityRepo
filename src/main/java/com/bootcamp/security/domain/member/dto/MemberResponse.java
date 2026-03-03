package com.bootcamp.security.domain.member.dto;

import com.bootcamp.security.domain.member.entity.Member;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record MemberResponse(
        String name,
        String username,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime joinedAt,
        String role
) {
    public static MemberResponse from(Member member) {
        return new MemberResponse(member.getName(),member.getUsername(),member.getCreatedAt(),member.getRole().name());
    }
}
