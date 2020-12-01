package com.samal.greenstone.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@SpringBootApplication
@RestController
public class GreenstoneApplication {
//    @GetMapping("/user")
//    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
//        return Collections.singletonMap("name", principal.getAttribute("name"));
//    }

//    @GetMapping("/error")
//    @ResponseBody
//    public String error(HttpServletRequest request) {
//        String message = (String) request.getSession().getAttribute("error.message");
//        request.getSession().removeAttribute("error.message");
//        return message;
//    }

    public static void main(String[] args) {
        SpringApplication.run(GreenstoneApplication.class, args);
    }
}
