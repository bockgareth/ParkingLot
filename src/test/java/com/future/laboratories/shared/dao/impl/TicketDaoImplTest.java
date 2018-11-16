package com.future.laboratories.shared.dao.impl;

import com.future.laboratories.entity.TicketEntity;
import com.future.laboratories.shared.dao.TicketDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;

public class TicketDaoImplTest {

    @Mock
    JdbcTemplate jdbcTemplate;

    @Mock
    TicketDaoImpl ticketDao;

    TicketEntity ticketEntity;

    @Before
    public void setUp() throws Exception {
        ticketDao = new TicketDaoImpl();
        ticketEntity = new TicketEntity();
    }

    @Test
    public void testGetTicketById() {
        // To be implemented at a later date.
    }

    @Test
    public void testGetAllTickets() {
        // To be implemented at a later date.
    }

    @Test
    public void testCreateTicket() {
        // To be implemented at a later date.
    }

    @Test
    public void testUpdateTicket() {
        // To be implemented at a later date.
    }
}