package com.secure_book_review.secure_book_review.dto.reviewDto;

import com.secure_book_review.secure_book_review.model.Book;
import com.secure_book_review.secure_book_review.model.User;

public record ReviewDtoRequest(String content,int rating, User user, Book book) {
    // This is a record in Java, it automatically generates the constructor, getters, equals, hashCode and toString methods.
    // You can add additional methods if needed.){
}
