package com.farrukh.aireview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Main entry point for the AI Code Review Assistant Spring Boot application.
 * This class initializes and starts the Spring Boot application context.
 * It automatically enables component scanning, autoconfiguration, and property support.
 */
@SpringBootApplication
@EnableJpaAuditing
public class AiCodeReviewAssistantApplication {
    /**
     * Main method - entry point for the Spring Boot application.
     * Bootstraps the application and starts the Spring context.
     *
     * @param args Command-line arguments passed to the application
     */
    public static void main(String[] args) {
        SpringApplication.run(AiCodeReviewAssistantApplication.class, args);
    }

}
