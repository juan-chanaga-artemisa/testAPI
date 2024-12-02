package com.example.SampleService.controller;

import com.example.SampleService.dto.UserLogin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String pingBack() {
        return "The back is running";
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, this is a simple response from the Java service!";
    }

    @PostMapping("/login")
    public UserLogin login(@RequestBody UserLogin userLogin) {
        return userLogin;
    }
}
