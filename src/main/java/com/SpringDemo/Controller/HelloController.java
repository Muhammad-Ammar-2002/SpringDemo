package com.SpringDemo.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;

@RestController
@RequestMapping
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(HttpServletRequest request) {

        return "Hello, World!\n Session ID: " + request.getSession().getId();
    }

    @GetMapping("/about")
    public String about(HttpServletRequest request) {
        return "This is a Spring Boot REST API application 2025 \n Session ID: " + request.getSession().getId();
    }
}