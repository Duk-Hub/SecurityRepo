package com.bootcamp.security.global.common;

import com.bootcamp.security.domain.member.entity.Member;
import com.bootcamp.security.domain.member.entity.Role;
import com.bootcamp.security.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


/**
 *과제 테스트용 계정
 */
@Component
@RequiredArgsConstructor
public class AccountInitializer implements CommandLineRunner {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (!memberRepository.existsByUsername("ADMIN")){
            Member member = new Member("ADMIN","ADMIN", passwordEncoder.encode("admin123!"), Role.ADMIN);
            memberRepository.save(member);
        }
        if (!memberRepository.existsByUsername("MANAGER")){
            Member member = new Member("MANAGER","MANAGER", passwordEncoder.encode("manager123!"), Role.MANAGER);
            memberRepository.save(member);
        }
        if (!memberRepository.existsByUsername("USER")){
            Member member = new Member("USER","USER", passwordEncoder.encode("user123!"), Role.USER);
            memberRepository.save(member);
        }
    }
}
