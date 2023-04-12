package com.greatlearning.tta.controller;
import java.text.SimpleDateFormat;  
import java.util.Date;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.greatlearning.tta.service.TicketService;
import com.greatlearning.tta.entity.Ticket;


@Controller
public class TicketController {


    private TicketService ticketService;


    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
   
    @GetMapping("/tickets")
    public String listTickets(Model model) {
        model.addAttribute("tickets", ticketService.getAllTickets());
        return "tickets";
    }  
    
    @GetMapping("/tickets/new")
   public String createTicketForm(Model model) {
       // create ticket object to hold ticket form data
       Ticket ticket = new Ticket();
       model.addAttribute("ticket", ticket);
       return "create_ticket";
   }


   @PostMapping("/tickets")
   public String saveTicket(
           @ModelAttribute("ticket") Ticket ticket) {
	   SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	   Date date = new Date();  
	   String currentDate = formatter.format(date).toString().replace('/', ' ');
	   ticket.setDateCreatedOn(currentDate);
       ticketService.saveTicket(ticket);
       return "redirect:/tickets";
   }  
   
   @GetMapping("/tickets/edit/{id}")
	public String editTicketForm(@PathVariable Long id, Model model) {
		model.addAttribute("ticket", ticketService.getTicketById(id));
		return "edit_ticket";
	}
   
   @GetMapping("/tickets/view/{id}")
	public String viewTicketForm(@PathVariable Long id, Model model) {
		model.addAttribute("ticket", ticketService.getTicketById(id));
		return "view_ticket";
	}
   
   @PostMapping("/tickets/{id}")
	public String updateTicket(
			@PathVariable Long id, 
			@ModelAttribute("ticket") Ticket ticket, 
			Model model) {

		// get ticket from database by id
		Ticket existingTicket = ticketService.getTicketById(id);
		existingTicket.setId(id);
		existingTicket.setTitle(ticket.getTitle());
		existingTicket.setShortDescription(ticket.getShortDescription());
		existingTicket.setContent(ticket.getContent());

		// save updated ticket object
		ticketService.updateTicket(existingTicket);
		return "redirect:/tickets";
	}	

   
   @GetMapping("/tickets/{id}")
   public String deleteTicket(@PathVariable Long id) {
       ticketService.deleteTicketById(id);
       return "redirect:/tickets";
   }
   
   @RequestMapping("/")
   public String viewHomePage(Model model, @Param("keyword") String keyword) {
       model.addAttribute("tickets", ticketService.listAll(keyword));
       model.addAttribute("keyword", keyword);
        
       return "tickets";
   }

   

   
   

   
}
