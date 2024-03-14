package com.beantastic.api.controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    public void configure(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((auth) ->
                auth.requestMatchers("/").permitAll()
                    .anyRequest().authenticated());
    }
}
