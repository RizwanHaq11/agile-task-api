package com.example.agileapi.controller;

import com.example.agileapi.dto.*;
import com.example.agileapi.model.User;
import com.example.agileapi.security.JwtUtil;
import com.example.agileapi.repository.UserRepository;
import com.example.agileapi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final UserService userService;
    private final UserRepository userRepository;

    public AuthController(AuthenticationManager authManager, JwtUtil jwtUtil, UserService userService, UserRepository ur) {
        this.authManager = authManager; this.jwtUtil = jwtUtil; this.userService = userService; this.userRepository = ur;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody AuthRequest req) {
        User u = userService.register(req.getUsername(), req.getPassword());
        return ResponseEntity.ok(u);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest req) {
        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
        String token = jwtUtil.generateToken(req.getUsername());
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
