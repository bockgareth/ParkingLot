package com.future.laboratories.service;

import com.future.laboratories.shared.dto.TicketDto;

import java.util.List;

public interface TicketService {
    public TicketDto getTicketById(int id);
    public List<TicketDto> getAllTickets();
    public TicketDto createTicket(TicketDto ticket);
    public TicketDto updateTicket(int id, TicketDto ticket);
}
