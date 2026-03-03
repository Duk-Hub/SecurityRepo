package com.bootcamp.security.domain.member.dto;

import com.bootcamp.security.domain.member.entity.Member;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record MemberSummaryResponse(
        String name,
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate joinedDate
) {
    public static MemberSummaryResponse from(Member member) {
        return new MemberSummaryResponse(member.getName(), member.getCreatedAt().toLocalDate());
    }
}
