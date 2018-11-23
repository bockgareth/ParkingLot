/* COPYRIGHT © 2018 GARETH BOCK AND/OR ITS AFFILIATES. ALL RIGHTS RESERVED. */

package com.future.laboratories.ticket.api.controller;

import com.future.laboratories.ticket.api.model.CreatedTicketResponseModel;
import com.future.laboratories.ticket.api.model.TicketResponseModel;
import com.future.laboratories.ticket.api.model.UpdatedTicketRequestModel;

import java.util.List;

public interface TicketController {

    public List<TicketResponseModel> getAllTickets();
    public TicketResponseModel getTicketById(int id);
    public CreatedTicketResponseModel createTicket();
    public TicketResponseModel updateTicket(int id, UpdatedTicketRequestModel ticketRequestModel);
}
