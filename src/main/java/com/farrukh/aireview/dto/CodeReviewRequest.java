package com.farrukh.aireview.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) for code review requests.
 * Encapsulates the input parameters required to submit source code for AI review.
 * Validates that both language and source code are provided.
 *
 * Fields:
 * - language: Programming language of the code (required)
 * - sourceCode: The actual source code to be reviewed (required)
 */
@Getter
@Setter
public class CodeReviewRequest {

    // Programming language identifier (e.g., "java", "python", "javascript")
    @NotBlank
    private String language;

    // Source code content to be analyzed by AI review
    @NotBlank
    private String sourceCode;

}
