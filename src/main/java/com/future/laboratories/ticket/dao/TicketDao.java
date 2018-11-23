/* COPYRIGHT © 2018 GARETH BOCK AND/OR ITS AFFILIATES. ALL RIGHTS RESERVED. */

package com.future.laboratories.ticket.dao;

import com.future.laboratories.ticket.entity.TicketEntity;
import org.springframework.jdbc.core.JdbcTemplate;

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
    public List<TicketEntity> getAllTicketsByMonth(int month);
    public List<TicketEntity> getAllTicketsByDay(int month, int day);
    public int getNoSpaceCount();
}
