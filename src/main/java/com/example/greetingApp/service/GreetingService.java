package com.example.greetingApp.service;

import org.springframework.stereotype.Service;

@Service  // Marks this class as a service layer component
public class GreetingService {

    public String getSimpleGreeting() {
        return "Hello, World!!";
    }
}