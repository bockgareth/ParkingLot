package com.future.laboratories.ui.controller;

import com.future.laboratories.service.TicketService;
import com.future.laboratories.service.impl.TicketServiceImpl;
import com.future.laboratories.shared.dto.TicketDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
public class TicketController {

    TicketService ticketService = new TicketServiceImpl();

    @GET
    @Path("/tickets")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TicketDto> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GET
    @Path("/tickets/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TicketDto getTicketById(@PathParam("id") int id) {
        return ticketService.getTicketById(id);
    }

    @POST
    @Path("/tickets")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TicketDto createTicket(TicketDto ticket) {
        return ticketService.createTicket(ticket);
    }

    @POST
    @Path("/tickets/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TicketDto updateTicket() {
        return null;
    }

}