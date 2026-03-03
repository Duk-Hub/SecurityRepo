package com.bootcamp.security.domain.member.repository;

import com.bootcamp.security.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
