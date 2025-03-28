package com.secure_book_review.secure_book_review.dto.bookDto;

import com.secure_book_review.secure_book_review.model.Book;
import com.secure_book_review.secure_book_review.model.Review;
import com.secure_book_review.secure_book_review.model.User;

public record BookDtoRequest(String title, String author, String description) {
    // This is a record in Java, it automatically generates the constructor, getters, equals, hashCode and toString methods.
    // You can add additional methods if needed.){
}
