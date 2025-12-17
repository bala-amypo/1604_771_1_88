package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users") // Good practice to avoid conflict with 'user' reserved keyword in some DBs
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assuming a standard auto-increment strategy
    private Long id;

    private String name;

    @Column(unique = true, nullable = false) // Ensures email uniqueness at the database level
    private String email;

    @Column(nullable = false)
    private String password; // Password will be hashed *before* saving to the database

    // Default role handling should be in the service layer or constructor/pre-persist method, 
    // but the field itself is a simple String.
    @Column(nullable = false)
    private String role = "RESIDENT"; // Can set default here or in a constructor/setter

}
