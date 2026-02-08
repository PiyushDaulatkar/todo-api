package com.lux.todoapi.service;

import com.lux.todoapi.dto.LoginResponse;
import com.lux.todoapi.entity.User;
import com.lux.todoapi.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public LoginResponse login(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtService.generateToken(user);
        return new LoginResponse(token);
    }
}
