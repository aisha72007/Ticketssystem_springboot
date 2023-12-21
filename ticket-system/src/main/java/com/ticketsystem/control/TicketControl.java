package com.ticketsystem.control;

import com.ticketsystem.entity.Ticket;
import com.ticketsystem.service.TicketService;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/ticket")
public class TicketControl {
    @Autowired
    private TicketService ticketService;
//http://localhost:8080/ticket/add
    @PostMapping(value = "/add",
    produces = {"application/json"}, consumes = {"application/json"}
    )
    public ResponseEntity<Ticket> addTicket(@RequestBody Ticket newTicket){
        Ticket ticket = ticketService.addTicket(newTicket);
        return ResponseEntity.status(CREATED).body(ticket);
    }
    @DeleteMapping("/add")
    public void deleteTicket(){
        ticketService.deleteTicket();
    }
}
