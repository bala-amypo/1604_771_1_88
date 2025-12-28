package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.JwtResponse;
import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(UserService userService,
                          AuthenticationManager authenticationManager,
                          JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    // ✅ REGISTER (unchanged)
    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {

        User user = new User(
                null,
                request.getName(),
                request.getEmail(),
                request.getPassword(),
                "RESIDENT"
        );

        return userService.register(user);
    }

    // 🔐 LOGIN (RETURNS TOKEN)
    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {

        // 1️⃣ Authenticate credentials
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        // 2️⃣ Fetch user from DB
        User user = userService.login(
                request.getEmail(),
                request.getPassword()
        );

        // 3️⃣ Generate JWT token
        String token = jwtTokenProvider.generateToken(
                authentication,
                user.getId(),
                user.getEmail(),
                user.getRole()
        );

        // 4️⃣ RETURN TOKEN (IMPORTANT)
        return new JwtResponse(token);
    }
}
