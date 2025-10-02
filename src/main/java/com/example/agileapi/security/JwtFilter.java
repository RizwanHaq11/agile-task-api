package com.example.agileapi.security;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

public class JwtFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final UserDetailsServiceImpl userDetailsService;
    public JwtFilter(JwtUtil jwtUtil, UserDetailsServiceImpl uds) { this.jwtUtil = jwtUtil; this.userDetailsService = uds; }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        String token = null;
        if (StringUtils.hasText(header) && header.startsWith("Bearer ")) {
            token = header.substring(7);
        }
        if (token != null && jwtUtil.validateToken(token)) {
            String username = jwtUtil.getUsernameFromToken(token);
            UserDetails ud = userDetailsService.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(ud, null, ud.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        filterChain.doFilter(request, response);
    }
}
