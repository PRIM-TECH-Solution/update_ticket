package com.example.ticketbooking.service;

import com.example.ticketbooking.exception.ResourceNotFoundException;
import com.example.ticketbooking.model.Ticket;
import com.example.ticketbooking.model.User;
import com.example.ticketbooking.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
    private final UserService userService;

    public List<Ticket> getAllTickets(String username) {
        Optional<Object> optionalUser =  userService.getUserByUsername(username);

        User user = optionalUser.map(u -> (User) u).orElse(null);
// Now you can pass the user object to findByUser method

        return ticketRepository.findUser(user);
    }

    public Ticket createTicket(String username, Ticket ticket) {
        Optional<Object> user = userService.getUserByUsername(username);
        ticket.setUser(null);
        return ticketRepository.save(ticket);
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow();
    }

    public Ticket updateTicket(Long id, Ticket updatedTicket) {
        Ticket ticket = getTicketById(id);
        // Update ticket properties
        return ticketRepository.save(ticket);
    }

    public void deleteTicket(Long id) {
        Ticket ticket = getTicketById(id);
        ticketRepository.delete(ticket);
    }
}
