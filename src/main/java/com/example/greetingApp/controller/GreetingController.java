package com.example.greetingApp.controller;


import com.example.greetingApp.model.Greeting;
import com.example.greetingApp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/hello")
    public String getSimpleGreeting() {
        return greetingService.getSimpleGreeting();
    }

    @GetMapping("/personalized")
    public String getPersonalizedGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return greetingService.getPersonalizedGreeting(firstName, lastName);
    }

    @PostMapping
    public Greeting saveGreeting(@RequestParam String message) {
        return greetingService.saveGreeting(message);
    }

    @GetMapping("/{id}")
    public String findGreetingById(@PathVariable Long id) {
        return greetingService.findGreetingById(id)
                .map(Greeting::getMessage)
                .orElse("Greeting not found!");
    }

    @GetMapping
    public List<Greeting> findAllGreetings() {
        return greetingService.findAllGreetings();
    }

    // ✅ UC7: Edit a Greeting
    @PutMapping("/{id}")
    public Optional<Greeting> editGreeting(@PathVariable Long id, @RequestParam String message) {
        return greetingService.editGreeting(id, message);
    }
}