package com.future.laboratories.ui.controller;

import com.future.laboratories.service.TicketService;
import com.future.laboratories.service.impl.TicketServiceImpl;
import com.future.laboratories.shared.dto.TicketDto;
import com.future.laboratories.ui.model.response.ticket.TicketResponseModel;
import org.springframework.beans.BeanUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * This class acts as the ticket controller that hosts HTTP endpoints
 * for ticket related queries.
 */
@Path("/")
public class TicketController {

    /**
     * com.future.laboratories.service.impl.TicketServiceImpl to be injected.
     */
    TicketService ticketService = new TicketServiceImpl();

    /**
     * GET (on 200 OK) request to retrieve all tickets.
     * @return a TicketDto List<E> as a response, output declared as json.
     */
    @GET
    @Path("/tickets")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TicketDto> getAllTickets() {

        return ticketService.getAllTickets();
    }

    /**
     * GET (on 200 OK) request to retrieve a single ticket based on a ticket id.
     * @param id the id of a ticket that will be requested.
     * @return a TicketDto as a response, output declared as json.
     */
    @GET
    @Path("/tickets/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TicketResponseModel getTicketById(@PathParam("id") int id) {
        TicketResponseModel returnValue = new TicketResponseModel();

        TicketDto ticketDto = ticketService.getTicketById(id);
        BeanUtils.copyProperties(ticketDto, returnValue);

        return returnValue;
    }

    /**
     * POST (on 200 OK) request to create a single ticket.
     * @param ticket the TicketDto object that comes in the request body.
     * @return a TicketDto as a response, output declared as json.
     */
    @POST
    @Path("/tickets")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TicketDto createTicket(TicketDto ticket) {
        return ticketService.createTicket(ticket);
    }

    /**
     * PUT (on 200 OK) request to update a ticket. Used for closing a ticket.
     * @param id the id of a ticket that will be requested.
     * @param ticket the TicketDto object that comes in the request body.
     * @return a TicketDto as a response, output declared as json.
     */
    @PUT
    @Path("/tickets/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TicketDto updateTicket(@PathParam("id") int id, TicketDto ticket) {
        return ticketService.updateTicket(id, ticket);
    }

}