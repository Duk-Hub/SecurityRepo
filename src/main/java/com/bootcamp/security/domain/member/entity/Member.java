package com.bootcamp.security.domain.member.entity;

import com.bootcamp.security.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(uniqueConstraints = @UniqueConstraint(name = "UQ_MEMBER_USERNAME",columnNames = "username"))
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public Member(String name, String username, String password,  Role role) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public void setManager(){
        this.role = Role.MANAGER;
    }

    public void setAdmin(){
        this.role = Role.ADMIN;
    }
}
