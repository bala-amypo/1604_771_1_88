package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final UserService userService;

  public AuthController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/register")
  public ResponseEntity<User> register(@RequestBody User user) {
    return ResponseEntity.ok(userService.register(user));
  }

  @PostMapping("/login")
  public ResponseEntity<String> login(@RequestBody User user) {
    // Placeholder for now — later you’ll add JWT here
    return ResponseEntity.ok("Login successful (JWT logic to be added)");
  }
}
