package com.secure_book_review.secure_book_review.repository;

import com.secure_book_review.secure_book_review.dto.userDto.UserDtoResponse;
import com.secure_book_review.secure_book_review.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User,Long> {
    Optional<User> findByUsername(String username);
}
