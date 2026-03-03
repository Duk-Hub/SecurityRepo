package com.bootcamp.security.domain.member.service;

import com.bootcamp.security.domain.member.dto.MemberCreateRequest;
import com.bootcamp.security.domain.member.dto.MemberResponse;
import com.bootcamp.security.domain.member.dto.MemberSummaryResponse;
import com.bootcamp.security.domain.member.entity.Member;
import com.bootcamp.security.domain.member.entity.Role;
import com.bootcamp.security.domain.member.repository.MemberRepository;
import com.bootcamp.security.global.exception.MemberNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void join(MemberCreateRequest request) {
        Member member = Member.builder()
                .name(request.name())
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.USER)
                .build();
        memberRepository.save(member);
        log.info("회원가입 완료 : {}", member.getId());
    }

    public List<MemberSummaryResponse> findAll(){
        return memberRepository.findAll()
                .stream()
                .map(MemberSummaryResponse::from)
                .toList();
    }

    public MemberResponse showDetails(String username) {
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new MemberNotFoundException("Member Not Found"));
        return MemberResponse.from(member);
    }
}
