package com.future.laboratories.shared.dao;

import com.future.laboratories.entity.TicketEntity;

public interface TicketDao {
    public int getTicketCount();
    public TicketEntity getTicketById(int id);
}
