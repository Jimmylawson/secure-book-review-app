package com.secure_book_review.secure_book_review.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@RequiredArgsConstructor
@Getter @Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private int rating;
    @ManyToOne
    private User user; /// This establishes a many-to-one relationship with the User entity

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    private Book book;
}
