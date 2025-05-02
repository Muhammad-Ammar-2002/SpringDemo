package com.test.security.Controller;

import com.test.security.Exceptions.CustomResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.CacheResponse;
import java.net.http.HttpRequest;

@RestController
@RequestMapping
public class HelloController {

    @GetMapping("/hello")
    public ResponseEntity<?> sayHello(HttpServletRequest request) {

        return ResponseEntity.ok(new CustomResponse("200",
                "success"
        ,"Hello, World!\n Session ID: " + request.getSession().getId()));
    }

}