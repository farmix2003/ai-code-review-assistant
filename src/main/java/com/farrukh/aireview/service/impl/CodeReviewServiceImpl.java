package com.farrukh.aireview.service.impl;

import com.farrukh.aireview.entity.CodeReview;
import com.farrukh.aireview.entity.User;
import com.farrukh.aireview.repository.CodeReviewRepository;
import com.farrukh.aireview.service.CodeReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the CodeReviewService interface.
 * Provides the concrete business logic for managing code review operations.
 *
 * This service acts as an intermediary between the presentation layer and
 * the repository layer, handling all code review-related business operations.
 *
 * Dependencies are injected via constructor using Lombok's @RequiredArgsConstructor.
 */
@Service
@RequiredArgsConstructor
public class CodeReviewServiceImpl implements CodeReviewService {

    // Repository for performing database operations on code reviews
    private final CodeReviewRepository codeReviewRepository;

    /**
     * {@inheritDoc}
     * Delegates to the repository to save the code review to the database.
     */
    @Override
    public CodeReview save(CodeReview codeReview) {
        return codeReviewRepository.save(codeReview);
    }

    /**
     * {@inheritDoc}
     * Retrieves the first code review submitted by the specified user.
     */
    @Override
    public List<CodeReview> getUserReview(User user) {
        return codeReviewRepository.findByUserId(user.getId());
    }
}
