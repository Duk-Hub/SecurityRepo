package com.bootcamp.security.domain.member.controller;

import com.bootcamp.security.domain.member.dto.MemberCreateRequest;
import com.bootcamp.security.domain.member.service.MemberService;
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
    public String signup(MemberCreateRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "auth/signup";
        }
        memberService.join(request);
        return "redirect:/";
    }
}
