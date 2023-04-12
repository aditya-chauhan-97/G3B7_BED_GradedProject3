package com.greatlearning.tta.service;

import java.util.List;

import com.greatlearning.tta.entity.Ticket;

public interface TicketService {
		
	List<Ticket> getAllTickets();
	
	List<Ticket> listAll(String keyword);
	
	Ticket saveTicket(Ticket ticket);
	
	Ticket getTicketById(Long id);
	   
	Ticket updateTicket(Ticket ticket);

	void deleteTicketById(Long id);

}

