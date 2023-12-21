package com.ticketsystem.service;

import com.ticketsystem.control.TicketControl;
import com.ticketsystem.entity.Ticket;
import com.ticketsystem.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.*;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    public Ticket addTicket(Ticket newTicket){
        newTicket.setCreateDate(now());
        return ticketRepository.save(newTicket);
    }
    public void deleteTicket(){
        ticketRepository.deleteAll();
    }
}
