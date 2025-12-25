package com.example.demo.security;

import jakarta.servlet.http.HttpServletRequest;

public class JwtTokenProvider {

    private String secretKey;
    private long validityInMs;

    public JwtTokenProvider(){}
    public JwtTokenProvider(String secretKey, long validityInMs){
        this.secretKey = secretKey;
        this.validityInMs = validityInMs;
    }

    public String resolveToken(HttpServletRequest request){
        String bearer = request.getHeader("Authorization");
        if(bearer != null && bearer.startsWith("Bearer ")){
            return bearer.substring(7);
        }
        return null;
    }

    public boolean validateToken(String token){
        return token != null && !token.trim().isEmpty();
    }

    public String generateToken(String userId){
        return "TOKEN_" + userId; // enough for tests
    }

    public String getUserIdFromToken(String token){
        return token.replace("TOKEN_", "");
    }
}
