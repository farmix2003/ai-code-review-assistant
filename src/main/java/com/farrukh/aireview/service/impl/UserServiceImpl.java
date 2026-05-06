package com.farrukh.aireview.service.impl;

import com.farrukh.aireview.entity.User;
import com.farrukh.aireview.repository.UserRepository;
import com.farrukh.aireview.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Implementation of the UserService interface.
 * Provides the concrete business logic for managing user operations.
 *
 * This service acts as an intermediary between the presentation layer and
 * the repository layer, handling all user-related business operations including
 * registration and authentication.
 *
 * Dependencies are injected via constructor using Lombok's @RequiredArgsConstructor.
 */
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    // Repository for performing database operations on users
    private final UserRepository userRepository;

    /**
     * {@inheritDoc}
     * Delegates to the repository to save the user to the database.
     */
    @Override
    public User register(User user) {
        return userRepository.save(user);
    }

    /**
     * {@inheritDoc}
     * Retrieves a user by email and throws an exception if not found.
     *
     * @throws RuntimeException with a descriptive error message if the user is not found
     */
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() ->  new RuntimeException("User not found with email: " + email));
    }
}
