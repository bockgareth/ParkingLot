package com.future.laboratories.ui.controller;

import com.future.laboratories.service.TicketService;
import com.future.laboratories.service.impl.TicketServiceImpl;
import com.future.laboratories.shared.dto.TicketDto;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
public class TicketController {

    TicketService ticketService = new TicketServiceImpl();

    @GET
    @Path("/tickets/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TicketDto getTicketById(@PathParam("id") int id) {
        return ticketService.getTicketById(id);
    }

    @GET
    @Path("/tickets")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TicketDto> getAllTickets() {
        return ticketService.getAllTickets();
    }
}