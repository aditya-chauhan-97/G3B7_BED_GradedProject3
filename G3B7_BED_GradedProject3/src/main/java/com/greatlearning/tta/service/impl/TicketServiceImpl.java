package com.greatlearning.tta.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.greatlearning.tta.entity.Ticket;
import com.greatlearning.tta.repository.TicketRepository;
import com.greatlearning.tta.service.TicketService;


@Service
public class TicketServiceImpl implements TicketService{

	@Autowired
    private TicketRepository ticketRepository;
   
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
    
    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }
    
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).get();
    }


    public Ticket updateTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }
    
    public void deleteTicketById(Long id) {
        ticketRepository.deleteById(id);
    }
    
    public List<Ticket> listAll(String keyword) {
        if (!keyword.isBlank()) {
            return ticketRepository.search(keyword);
        }
        return ticketRepository.findAll();
    }

    
}
