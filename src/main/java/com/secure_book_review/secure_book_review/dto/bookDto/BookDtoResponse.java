package com.secure_book_review.secure_book_review.dto.bookDto;

import com.secure_book_review.secure_book_review.dto.reviewDto.ReviewDtoResponse;
import com.secure_book_review.secure_book_review.model.Review;

import java.util.List;

public record BookDtoResponse(String title, String author, String description, List<ReviewDtoResponse> reviews) {
}
