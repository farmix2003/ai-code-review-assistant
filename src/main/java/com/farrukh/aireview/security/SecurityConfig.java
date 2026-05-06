package com.farrukh.aireview.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring Security configuration for the application.
 * Configures security policies including CSRF protection, authorization rules, and password encoding.
 *
 * Current configuration:
 * - CSRF protection disabled (suitable for REST APIs with stateless authentication)
 * - All HTTP requests permitted without authentication (no authorization restrictions)
 * - BCrypt password encoding for secure password storage
 */
@Configuration
public class SecurityConfig {

    /**
     * Configures the security filter chain for HTTP requests.
     * Disables CSRF protection and permits all requests without authentication.
     *
     * @param http the HttpSecurity object to configure
     * @return configured SecurityFilterChain
     * @throws Exception if configuration fails
     */
    @Bean
    public SecurityFilterChain  securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()
                );

        return  http.build();
    }

    /**
     * Provides a password encoder bean using BCrypt algorithm.
     * BCrypt is a cryptographically strong password hashing function that includes salt
     * to prevent rainbow table attacks.
     *
     * @return BCryptPasswordEncoder instance for password encoding/verification
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
