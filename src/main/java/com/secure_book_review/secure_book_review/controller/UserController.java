package com.secure_book_review.secure_book_review.controller;


import com.secure_book_review.secure_book_review.dto.userDto.UserDtoRequest;
import com.secure_book_review.secure_book_review.dto.userDto.UserDtoResponse;
import com.secure_book_review.secure_book_review.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
@RequiredArgsConstructor
public class UserController {
    UserService userService;

    @PostMapping("/register/user")
    public ResponseEntity<UserDtoResponse> registerUser(@RequestBody UserDtoRequest user){
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDtoResponse>> getAllUsers(){
        try{
            return ResponseEntity.ok(userService.findAll());
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<UserDtoResponse> findUserById(@PathVariable Long id){
        try{
            var user = userService.findById(id);
            return ResponseEntity.ok(user.orElse(null));
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<UserDtoResponse> deleteUserById(@PathVariable Long id){
        // This method will delete a user by ID
        // It will return a response indicating success or failure
        try {
            userService.deleteById(id);
            return ResponseEntity.ok().build(); // Success response
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); // Not found response
        }
    }
}
