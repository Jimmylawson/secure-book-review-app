package com.secure_book_review.secure_book_review.dto.reviewDto;

import com.secure_book_review.secure_book_review.model.Book;
import com.secure_book_review.secure_book_review.model.User;

public record ReviewDtoResponse(String content, int rating,String username,String bookTitle) {
}
