package com.future.laboratories.shared.dao;

import com.future.laboratories.entity.TicketEntity;

import java.util.List;

/**
 * Interface to implemented for all ticket related data access
 * layer objects.
 */
public interface TicketDao {
    public TicketEntity getTicketById(int id);
    public List<TicketEntity> getAllTickets();
    public void createTicket(TicketEntity ticket);
    public void updateTicket(TicketEntity ticket);
}
