package com.bootcamp.security.domain.member.service;

import com.bootcamp.security.domain.member.dto.MemberCreateRequest;
import com.bootcamp.security.domain.member.dto.MemberResponse;
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

    @Transactional
    public void setManager(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException("Member not found"));
        member.setManager();
        log.info("권한 변경 완료: {} {}", member.getId(), member.getRole());
    }

    @Transactional
    public void setAdmin(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException("Member not found"));
        member.setAdmin();
        log.info("권한 변경 완료: {} {}", member.getId(), member.getRole());
    }

    public List<MemberResponse> findAll(){
        return memberRepository.findAll()
                .stream()
                .map(MemberResponse::from)
                .toList();
    }
}
