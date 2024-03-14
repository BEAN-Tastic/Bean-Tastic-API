package com.beantastic.api.controllers;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
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

    private boolean isValidToken(String token) {
        // Add your token validation logic here, such as validating against GitHub's authentication service
        // For demonstration purposes, we assume all non-empty tokens are valid
        return StringUtils.hasText(token);
    }
}
