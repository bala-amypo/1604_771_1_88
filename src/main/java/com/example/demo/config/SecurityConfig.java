package com.example.demo.config;

import com.example.demo.security.JwtAuthenticationEntryPoint;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.security.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.withUsername("admin")
                        .password(passwordEncoder().encode("admin123"))
                        .roles("ADMIN")
                        .build()
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtTokenProvider jwtTokenProvider() {
        return new JwtTokenProvider(
                "MySuperSecretJwtKeyForApartmentSystem123456",
                3600000L
        );
    }

    @Bean
    public JwtAuthenticationEntryPoint authenticationEntryPoint() {
        return new JwtAuthenticationEntryPoint();
    }

    // 🔥 ADD THIS FILTER CHAIN - IMPORTANT
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().and()
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint()).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll() // login, register
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                        .requestMatchers("/facilities/**").hasRole("ADMIN") // Only admin can manage facilities
                        .anyRequest().authenticated()
                );

        // Add JWT filter before UsernamePasswordAuthenticationFilter
        http.addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider()), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
