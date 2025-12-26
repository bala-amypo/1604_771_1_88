package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public JwtTokenProvider() {}

    public String generateToken(String subject) {
        return "TOKEN_" + subject;
    }

    public boolean validateToken(String token) {
        return token != null && token.startsWith("TOKEN_");
    }

    public String getUserIdFromToken(String token) {
        return token.replace("TOKEN_", "");
    }

    public String getEmailFromToken(String token) {
        return getUserIdFromToken(token);
    }

    public String getRoleFromToken(String token) {
        return "USER";
    }
}
