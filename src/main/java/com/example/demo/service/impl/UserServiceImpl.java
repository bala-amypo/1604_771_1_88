package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User register(User user) {
    if (user == null) throw new IllegalArgumentException("User cannot be null");
    if (!StringUtils.hasText(user.getEmail())) throw new IllegalArgumentException("Email is required");
    if (!StringUtils.hasText(user.getName())) throw new IllegalArgumentException("Name is required");
    if (!StringUtils.hasText(user.getPassword())) throw new IllegalArgumentException("Password is required");

    if (userRepository.existsByEmail(user.getEmail())) {
      throw new BadRequestException("Email duplicate");
    }

    if (user.getRole() == null || user.getRole().isBlank()) {
      user.setRole("RESIDENT");
    } else {
      String role = user.getRole().trim().toUpperCase();
      if (!role.equals("RESIDENT") && !role.equals("ADMIN")) {
        throw new IllegalArgumentException("Invalid role");
      }
      user.setRole(role);
    }

    return userRepository.save(user);
  }

  @Override
  public User findByEmail(String email) {
    return userRepository.findByEmail(email)
        .orElseThrow(() -> new ResourceNotFoundException("User not found"));
  }

  @Override
  public User getById(Long id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User not found"));
  }
}
