package com.future.laboratories.ticket.api.controller.impl;

import com.future.laboratories.ticket.api.controller.TicketController;
import com.future.laboratories.ticket.api.model.UpdatedTicketRequestModel;
import com.future.laboratories.ticket.service.TicketService;
import com.future.laboratories.ticket.service.impl.TicketServiceImpl;
import com.future.laboratories.ticket.dto.TicketDto;
import com.future.laboratories.ticket.api.model.CreatedTicketResponseModel;
import com.future.laboratories.ticket.api.model.TicketResponseModel;
import org.springframework.beans.BeanUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * This class acts as the ticket controller that hosts HTTP endpoints
 * for ticket related queries.
 */
@Path("/")
public class TicketControllerImpl implements TicketController {

    /**
     * com.future.laboratories.ticket.service.impl.TicketServiceImpl to be injected.
     */
    TicketService ticketService = new TicketServiceImpl();

    /**
     * GET (on 200 OK) request to retrieve all tickets.
     * @return a TicketDto List<E> as a response, output declared as json.
     */
    @GET
    @Path("/tickets")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TicketResponseModel> getAllTickets() {
        List<TicketResponseModel> returnValue = new ArrayList<>();

        List<TicketDto> tickets = ticketService.getAllTickets();

        for (TicketDto ticket: tickets) {
            TicketResponseModel responseModel = new TicketResponseModel();
            BeanUtils.copyProperties(ticket, responseModel);
            returnValue.add(responseModel);
        }

        return returnValue;
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
     * @return a TicketDto as a response, output declared as json.
     */
    @POST
    @Path("/tickets")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CreatedTicketResponseModel createTicket() {
        CreatedTicketResponseModel returnValue = new CreatedTicketResponseModel();

        TicketDto ticketDto = ticketService.createTicket();
        BeanUtils.copyProperties(ticketDto, returnValue);

        return returnValue;
    }

    /**
     * PUT (on 200 OK) request to update a ticket. Used for closing a ticket.
     * @param id the id of a ticket that will be requested.
     * @param ticketRequestModel the TicketDto object that comes in the request body.
     * @return a TicketDto as a response, output declared as json.
     */
    @PUT
    @Path("/tickets/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TicketResponseModel updateTicket(@PathParam("id") int id, UpdatedTicketRequestModel ticketRequestModel) {
        TicketResponseModel returnValue = new TicketResponseModel();

        TicketDto ticket = new TicketDto();

        ticket.setTicketDate(ticketRequestModel.getTicketDate());
        ticket.setExitTime(ticketRequestModel.getExitTime());
        ticket.setTicketLost(ticketRequestModel.isTicketLost());
        ticket.setId(id);

        TicketDto ticketDto = ticketService.updateTicket(ticket);
        BeanUtils.copyProperties(ticketDto, returnValue);


        return returnValue;
    }

}