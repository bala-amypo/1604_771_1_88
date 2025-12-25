package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // Example registration endpoint
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRequest userRequest) {

        // Check if email already exists
        if (userRepository.existsByEmail(userRequest.getEmail())) {
            return ResponseEntity.badRequest().body("Email is already in use!");
        }

        // Create user object (fixed constructor issue)
        User user = new User(
                null,                         // id
                userRequest.getFirstName(),    // firstName
                userRequest.getLastName(),     // lastName
                userRequest.getEmail(),        // email
                userRequest.getPassword(),     // password
                null                          // ApartmentUnit (null for now)
        );

        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully");
    }

    // Example login endpoint (simple version)
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());
        if (user == null || !user.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
        return ResponseEntity.ok("Login successful");
    }

    // DTOs for requests
    public static class UserRequest {
        private String firstName;
        private String lastName;
        private String email;
        private String password;

        // Getters and setters
        public String getFirstName() { return firstName; }
        public void setFirstName(String firstName) { this.firstName = firstName; }
        public String getLastName() { return lastName; }
        public void setLastName(String lastName) { this.lastName = lastName; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }

    public static class LoginRequest {
        private String email;
        private String password;

        // Getters and setters
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
}
