package com.example.demo.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import java.util.Collections;

public class UsernameAuth extends AbstractAuthenticationToken {

    private final String username;

    public UsernameAuth(String username) {
        super(Collections.emptyList());
        this.username = username;
    }

    @Override
    public Object getCredentials() {
        return "";
    }

    @Override
    public Object getPrincipal() {
        return username;
    }
}
