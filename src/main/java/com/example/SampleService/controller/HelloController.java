package com.example.SampleService.controller;

import org.springframework.web.bind.annotation.GetMapping;
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
}
