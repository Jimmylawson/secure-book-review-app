package com.secure_book_review.secure_book_review.service;

import com.secure_book_review.secure_book_review.dto.userDto.UserDtoRequest;
import com.secure_book_review.secure_book_review.dto.userDto.UserDtoResponse;
import com.secure_book_review.secure_book_review.exception.UserNotFoundException;
import com.secure_book_review.secure_book_review.model.User;
import com.secure_book_review.secure_book_review.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserService {
    UserRepository userRepository;

    public UserDtoResponse save(UserDtoRequest userdto){
        User userEntity = new User();
        // Convert UserDtoRequest to User entity
        userEntity.setUsername(userdto.username());
        userEntity.setEmail(userdto.email());
        userEntity.setPassword(userdto.password());

        /// Saving user
        User savedUser = userRepository.save(userEntity);
        // Return the saved user as UserDtoRequest

        return new UserDtoResponse(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail());
    }

   public  Optional<UserDtoResponse> findById(Long id) {
        Optional<User> user = userRepository.findById(id);

        return user.map(u->new UserDtoResponse(u.getId(), u.getUsername(), u.getEmail()));
    }

   public  Optional<UserDtoResponse> findByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(u->new UserDtoResponse(u.getId(), u.getUsername(), u.getEmail()));
    }

   public void deleteById(Long id) {
        if(!userRepository.existsById(id)){
            throw  new UserNotFoundException("User with ID " + id + " not found"); // This line will throw an exception if the user is not found
        }
        userRepository.deleteById(id);

    }

    public List<UserDtoResponse> findAll(){
        List<User> users = userRepository.findAll();

        return users.stream().map(u->new UserDtoResponse(u.getId(), u.getUsername(), u.getEmail())).toList();
    }

}
