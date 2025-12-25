package com.example.demo.security;

import org.springframework.stereotype.Component;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class JwtTokenProvider {

    private String secretKey = "secret-key";
    private long validityInMs = 3600000L;

    public JwtTokenProvider() {}
    public JwtTokenProvider(String secretKey, long validityInMs){
        this.secretKey = secretKey;
        this.validityInMs = validityInMs;
    }

    public String resolveToken(HttpServletRequest request){
        String bearer = request.getHeader("Authorization");
        if(bearer != null && bearer.startsWith("Bearer ")) return bearer.substring(7);
        return null;
    }

    public boolean validateToken(String token){ return token != null; }
    public String generateToken(String userId){ return "TOKEN_" + userId; }
    public String getUserIdFromToken(String token){ return token.replace("TOKEN_", ""); }
}
