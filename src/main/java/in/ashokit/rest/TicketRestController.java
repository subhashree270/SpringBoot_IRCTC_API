package in.ashokit.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.Passenger;
import in.ashokit.bindings.Ticket;
import in.ashokit.service.TicketService;

@RestController
public class TicketRestController {
	@Autowired
	private TicketService ticketSvc;
	
	@PostMapping("/ticket")
	public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger p){
		Ticket ticket = ticketSvc.bookTicket(p);
		return new ResponseEntity<>(ticket,HttpStatus.CREATED);
	}
	@GetMapping("/tickets")
	public ResponseEntity<Collection<Ticket>> getAllTickets(){
		Collection<Ticket> tickets = ticketSvc.getAllTickets();
		return new ResponseEntity<>(tickets,HttpStatus.OK);
	}

}
