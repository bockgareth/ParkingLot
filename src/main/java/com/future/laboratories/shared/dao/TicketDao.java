package com.future.laboratories.shared.dao;

import com.future.laboratories.entity.TicketEntity;

import java.util.List;

public interface TicketDao {
    public int getTicketCount();
    public TicketEntity getTicketById(int id);
    public List<TicketEntity> getAllTickets();
}
