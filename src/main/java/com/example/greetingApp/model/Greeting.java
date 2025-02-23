package com.example.greetingApp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity  // Marks this class as a database table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment ID
    private Long id;

    private String message;
}