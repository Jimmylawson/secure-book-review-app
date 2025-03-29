package com.secure_book_review.secure_book_review.controller;


import com.secure_book_review.secure_book_review.dto.userDto.UserDtoRequest;
import com.secure_book_review.secure_book_review.dto.userDto.UserDtoResponse;
import com.secure_book_review.secure_book_review.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;


    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @PostMapping("/register")
    public ResponseEntity<UserDtoResponse> registerUser(@Valid @RequestBody UserDtoRequest user){
        // Hash the password before saving
       UserDtoRequest secureUser = new UserDtoRequest(
               user.username(),
               user.email(),
               passwordEncoder.encode(user.password()),
               user.role()
       );
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(secureUser));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDtoResponse>> getAllUsers(){
        try{
            return ResponseEntity.ok(userService.findAll());
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<UserDtoResponse> findUserById(@PathVariable Long id){
        Optional<UserDtoResponse> user = userService.findById(id);

        return user.map(u->ResponseEntity.ok(u)).orElseGet(()->ResponseEntity.notFound().build());


    }

    @DeleteMapping("/user/{id}")
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
