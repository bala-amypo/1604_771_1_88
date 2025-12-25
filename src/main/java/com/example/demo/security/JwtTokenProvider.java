package com.example.demo.security;

public class JwtTokenProvider {

    private String secretKey;
    private long validityInMs;

    public JwtTokenProvider() {}

    // ⭐ Test expects this constructor
    public JwtTokenProvider(String secretKey, long validityInMs) {
        this.secretKey = secretKey;
        this.validityInMs = validityInMs;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public long getValidityInMs() {
        return validityInMs;
    }
}
