package com.bootcamp.security.domain.member.controller;

import com.bootcamp.security.domain.member.dto.MemberCreateRequest;
import com.bootcamp.security.domain.member.service.MemberService;
import com.bootcamp.security.global.exception.DuplicateUsernameException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {

    private final MemberService memberService;

    @GetMapping("/auth/signup")
    public String signupForm(@ModelAttribute("request") MemberCreateRequest request) {
        return "auth/signup";
    }

    @PostMapping("/auth/signup")
    public String signup(@Valid @ModelAttribute("request") MemberCreateRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "auth/signup";
        }
        try {
            memberService.join(request);
        } catch (DuplicateUsernameException e) {
            bindingResult.rejectValue("username", "duplicate","이미 사용중인 아이디입니다.");
            return "auth/signup";
        }
        return "redirect:/";
    }

    @GetMapping("/auth/login")
    public String loginForm(){
        return "auth/login";
    }
}
