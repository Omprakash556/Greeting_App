package com.example.greetingApp.controller;


import com.example.greetingApp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    @Autowired
    private GreetingService greetingService; // Injecting the service

    @GetMapping("/hello")
    public String getSimpleGreeting() {
        return greetingService.getSimpleGreeting(); // Calling the service method
    }
}