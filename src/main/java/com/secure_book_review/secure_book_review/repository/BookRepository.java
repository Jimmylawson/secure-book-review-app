package com.secure_book_review.secure_book_review.repository;

import com.secure_book_review.secure_book_review.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository <User,Long> {
}
