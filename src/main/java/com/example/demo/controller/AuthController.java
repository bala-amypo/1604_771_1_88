package com.example.demo.controller;


import com.example.demo.dto.*;
import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {


private final UserService userService;
private final AuthenticationManager authenticationManager;
private final JwtTokenProvider jwtTokenProvider;


public AuthController(UserService u, AuthenticationManager a, JwtTokenProvider j){
userService=u; authenticationManager=a; jwtTokenProvider=j;
}


@PostMapping("/register")
public ResponseEntity<?> register(@RequestBody RegisterRequest r){
User u = new User(null,r.getName(),r.getEmail(),r.getPassword(),"RESIDENT");
return ResponseEntity.ok(userService.register(u));
}


@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody LoginRequest r){
Authentication auth = authenticationManager.authenticate(
new UsernamePasswordAuthenticationToken(r.getEmail(),r.getPassword()));
String token = jwtTokenProvider.generateToken(auth,1L,r.getEmail(),"RESIDENT");
return ResponseEntity.ok(new LoginResponse(token));
}
}