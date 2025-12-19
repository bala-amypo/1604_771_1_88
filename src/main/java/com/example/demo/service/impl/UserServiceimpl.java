package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    UserRepository userRepository;
    
    
    public UserServiceimpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        
    }

    @Override
    public User register(User user) {
        
        return userRepository.save(user);
    }
}
