package in.ashokit.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import in.ashokit.bindings.Passenger;
import in.ashokit.bindings.Ticket;

@Service
public class TicketServiceImpl implements TicketService{
	
	Map<Integer,Ticket> db=new HashMap<>();
	
	@Override
	public Ticket bookTicket(Passenger p) {
		Ticket t=new Ticket();
		Random r=new Random();
		int i = r.nextInt(5);
		t.setTicketNum(i);
		BeanUtils.copyProperties(p, t);
		t.setStatus("CONFIRMED");
		db.put(i, t);
		
		return t;
	}
	
	@Override
	public Collection<Ticket> getAllTickets() {
		
		 Collection<Ticket> tickets = db.values();
		 return tickets;
	}

}
