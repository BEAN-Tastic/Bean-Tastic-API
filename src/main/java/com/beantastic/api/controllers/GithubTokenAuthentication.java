package com.beantastic.api.controllers;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClient;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class GithubTokenAuthentication extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = extractToken(request);
        if (StringUtils.hasText(token)) {
            if (isValidToken(token)) {
                // Token is valid, continue with the request
                filterChain.doFilter(request, response);
                return;
            }
        }
        // No token found, return unauthorized response
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }

    private String extractToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    private boolean isValidToken(String token){
        try {
            String response = RestClient.create().get()
                    .uri("https://api.github.com/user")
                    .header("Authorization", "Bearer " + token)
                    .retrieve()
                    .body(String.class);
            if (response == null || response.trim().isEmpty()) return false;
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
