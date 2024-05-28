package com.example.ticketbooking.service;

import com.example.ticketbooking.exception.BadRequestException;
import com.example.ticketbooking.model.User;
import com.example.ticketbooking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User registerUser(User user) {
        // Check if username or email already exists
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new BadRequestException("Username already exists");
        }
        // Hash the password
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        return userRepository.save(user);
    }

    public Optional<Object> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
