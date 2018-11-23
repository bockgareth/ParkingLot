/* COPYRIGHT © 2018 GARETH BOCK AND/OR ITS AFFILIATES. ALL RIGHTS RESERVED. */

package com.future.laboratories.ticket.service;

import com.future.laboratories.ticket.dto.TicketDto;

import java.util.List;

/**
 * Interface to implemented for all ticket related presentation
 * layer and service layer objects pert.
 */
public interface TicketService {
    public TicketDto getTicketById(int id);
    public List<TicketDto> getAllTickets();
    public TicketDto createTicket();
    public TicketDto updateTicket(TicketDto ticket);
}
