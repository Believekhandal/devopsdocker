package com.dockerdemo.dockerdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") // Optional base URL
public class HelloWorldController {

    @GetMapping("/hello") // Endpoint URL: /api/hello
    public String sayHello() {
        return "Hello, World!";
    }
}
