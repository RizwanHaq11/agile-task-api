package com.example.agileapi.security;

import com.example.agileapi.model.User;
import com.example.agileapi.repository.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    public UserDetailsServiceImpl(UserRepository userRepository) { this.userRepository = userRepository; }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new UserPrincipal(u);
    }
}
