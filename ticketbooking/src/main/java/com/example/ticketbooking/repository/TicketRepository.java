package com.example.ticketbooking.repository;

import com.example.ticketbooking.model.Ticket;
import com.example.ticketbooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findUser(User optionalUser);
}
