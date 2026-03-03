package com.bootcamp.security.global.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class ExceptionHandler {

    @GetMapping("/error/403")
    public String forbidden(){
        return "error/403";
    }
}
