package com.bootcamp.security.domain.member.controller;

import com.bootcamp.security.domain.member.dto.MemberCreateRequest;
import com.bootcamp.security.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {

    private final MemberService memberService;

    @GetMapping("/auth/signup")
    public String signupForm() {
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

    /**
     * 권한 테스트용
     */
    @GetMapping("/admin/{memberId}/setManager")
    public void setManager(@PathVariable Long memberId) {
        memberService.setManager(memberId);
    }

    @GetMapping("/admin/{memberId}/setAdmin")
    public void setAdmin(@PathVariable Long memberId) {
        memberService.setAdmin(memberId);
    }
}
