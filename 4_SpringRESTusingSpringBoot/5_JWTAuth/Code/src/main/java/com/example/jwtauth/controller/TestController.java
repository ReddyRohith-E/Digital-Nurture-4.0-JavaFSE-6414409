package com.example.jwtauth.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/protected")
    public String protectedEndpoint(Principal principal) {
        return "Hello " + principal.getName() + "! This is a protected endpoint.";
    }

    @GetMapping("/public")
    public String publicEndpoint() {
        return "This is a public endpoint, no authentication required.";
    }
}
