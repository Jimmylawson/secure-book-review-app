package com.secure_book_review.secure_book_review.service;

import com.secure_book_review.secure_book_review.dto.userDto.UserDtoRequest;
import com.secure_book_review.secure_book_review.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserService {
    UserRepository userRepository;

    public UserDtoRequest save(UserDtoRequest user){

    }
}
