package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;

import java.security.Key;
import java.util.Date;

public class JwtTokenProvider {

    private final Key key;
    private final long validityInMs;

    // STRICT constructor
    public JwtTokenProvider(String secret, long validityInMs) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.validityInMs = validityInMs;
    }

    public String generateToken(Authentication authentication,
                                Long userId,
                                String email,
                                String role) {

        Date now = new Date();
        Date expiry = new Date(now.getTime() + validityInMs);

        return Jwts.builder()
                .setSubject(String.valueOf(userId))
                .claim("userId", userId)
                .claim("email", email)
                .claim("role", role)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public Long getUserIdFromToken(String token) {
        Claims claims = getClaims(token);
        if (claims.get("userId") != null) {
            return claims.get("userId", Long.class);
        }
        return Long.valueOf(claims.getSubject());
    }

    public String getEmailFromToken(String token) {
        return getClaims(token).get("email", String.class);
    }

    public String getRoleFromToken(String token) {
        return getClaims(token).get("role", String.class);
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
