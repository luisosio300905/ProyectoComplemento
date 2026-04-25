package org.luis.proyecto.infrastructure.config;

import org.luis.proyecto.infrastructure.security.JwtAuthorizationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    private final JwtAuthorizationFilter jwtAuthorizationFilter;

    public WebSecurityConfig(JwtAuthorizationFilter jwtAuthorizationFilter) {
        this.jwtAuthorizationFilter = jwtAuthorizationFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, LOGIN_URL).permitAll()
                        .anyRequest().authenticated())
                .addFilterAfter(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
