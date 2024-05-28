package com.example.ticketbooking.service;

import com.example.ticketbooking.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository  extends CrudRepository<User, Long> {

    Optional<Object> findByUsername(String username);
}