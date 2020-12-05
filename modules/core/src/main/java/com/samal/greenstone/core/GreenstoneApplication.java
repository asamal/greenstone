package com.samal.greenstone.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@SpringBootApplication
@RestController
public class GreenstoneApplication {
    public static void main(String[] args) {
        SpringApplication.run(GreenstoneApplication.class, args);
    }
}
