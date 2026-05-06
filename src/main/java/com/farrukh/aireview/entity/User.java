package com.farrukh.aireview.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Entity representing a user in the AI Code Review Assistant system.
 * This entity manages user account information, authentication credentials, roles, and relationships
 * to code review submissions.
 * Features:
 * - Stores user authentication details (email, password)
 * - Manages user role and account status
 * - Tracks account creation and modification timestamps
 * - Maintains one-to-many relationship with CodeReview entities
 * - Uses Lombok annotations for reducing boilerplate code
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // User's unique email address used for authentication and communication
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    // User's password for authentication (typically stored encrypted)
    @Column(nullable = false)
    private String password;

    // User's role in the system (USER or ADMIN)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private Role role;

    // Flag indicating whether the user account is active/enabled
    @Column(nullable = false)
    private Boolean enabled;

    // Collection of code reviews submitted by this user
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<CodeReview> codeReviews;
}