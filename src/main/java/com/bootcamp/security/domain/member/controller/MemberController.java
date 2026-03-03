package com.bootcamp.security.domain.member.controller;

import com.bootcamp.security.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("members", memberService.findAll());
        return "member/list";
    }

    @GetMapping("/detail")
    public String showDetails(Authentication authentication, Model model){
        String username = authentication.getName();
        model.addAttribute("response",memberService.showDetails(username));
        return "member/detail";
    }
}
