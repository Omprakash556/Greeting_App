package com.example.greetingApp.service;

import com.example.greetingApp.model.Greeting;
import com.example.greetingApp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository repository;

    public String getSimpleGreeting() {
        return "Hello, World!";
    }

    public String getPersonalizedGreeting(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            return "Hello, " + firstName + "!";
        } else if (lastName != null) {
            return "Hello, " + lastName + "!";
        }
        return "Hello, World!";
    }

    public Greeting saveGreeting(String message) {
        return repository.save(new Greeting(null, message));
    }

    public Optional<Greeting> findGreetingById(Long id) {
        return repository.findById(id);
    }

    public List<Greeting> findAllGreetings() {
        return repository.findAll();
    }

    public Optional<Greeting> editGreeting(Long id, String newMessage) {
        return repository.findById(id).map(greeting -> {
            greeting.setMessage(newMessage);
            return repository.save(greeting);
        });
    }

    // ✅ UC8: Delete a Greeting
    public boolean deleteGreeting(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}