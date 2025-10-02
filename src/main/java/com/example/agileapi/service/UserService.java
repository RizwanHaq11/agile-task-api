package com.example.agileapi.service;

import com.example.agileapi.model.User;
import com.example.agileapi.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepository repo, PasswordEncoder encoder) { this.userRepository = repo; this.passwordEncoder = encoder; }

    public User register(String username, String rawPassword) {
        if (userRepository.findByUsername(username).isPresent()) throw new RuntimeException("Username exists");
        User u = User.builder().username(username).password(passwordEncoder.encode(rawPassword)).role("ROLE_USER").build();
        return userRepository.save(u);
    }
}
