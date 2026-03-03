package com.bootcamp.security.global.common;

import com.bootcamp.security.domain.member.entity.Member;
import com.bootcamp.security.domain.member.entity.Role;
import com.bootcamp.security.domain.member.repository.MemberRepository;
import com.bootcamp.security.domain.product.entity.Product;
import com.bootcamp.security.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


/**
 *과제 테스트용 데이터 입력
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        initMembers();
        initProducts();
    }

    private void initMembers() {
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

    private void initProducts() {
        for (int i = 1; i <= 20; i++) {
            Product product = new Product("상품 " + i, i*1000L,i*10L);
            productRepository.save(product);
        }
    }
}
