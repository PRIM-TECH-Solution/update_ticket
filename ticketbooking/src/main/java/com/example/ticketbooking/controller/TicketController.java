package com.example.ticketbooking.controller;

import com.example.ticketbooking.model.Ticket;
import com.example.ticketbooking.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @GetMapping
    public List<Ticket> getAllTickets(@RequestParam String username) {
        return ticketService.getAllTickets(username);
    }

    @PostMapping
    public Ticket createTicket(@RequestParam String username, @RequestBody Ticket ticket) {
        return ticketService.createTicket(username, ticket);
    }

    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable Long id) {
        return ticketService.getTicketById(id);
    }

    @PutMapping("/{id}")
    public Ticket updateTicket(@PathVariable Long id, @RequestBody Ticket ticket) {
        return ticketService.updateTicket(id, ticket);
    }

    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
    }
}
