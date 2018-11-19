package com.future.laboratories.service.impl;

import com.future.laboratories.ticket.entity.TicketEntity;
import com.future.laboratories.ticket.dao.impl.TicketDaoImpl;
import com.future.laboratories.ticket.dto.TicketDto;
import com.future.laboratories.ticket.service.impl.TicketServiceImpl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

public class TicketServiceImplTest {

    @InjectMocks
    TicketServiceImpl ticketService;

    @Mock
    TicketDaoImpl ticketDao;

    TicketEntity ticketEntity;
    TicketDto ticketDto;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        ticketEntity = new TicketEntity();
        ticketEntity.setId(1);
        ticketEntity.setTicketDate(LocalDate.of(2018, 11, 12));
        ticketEntity.setEnterTime(LocalTime.of(10, 30));
        ticketEntity.setExitTime(LocalTime.of(11, 30));
        ticketEntity.setTicketLost(false);
        ticketEntity.setAmountDue(20);

        ticketDto = new TicketDto();
        ticketDto.setId(1);
        ticketDto.setTicketDate(LocalDate.of(2018, 11, 12));
        ticketDto.setEnterTime(LocalTime.of(10, 30));
        ticketDto.setExitTime(LocalTime.of(11, 30));
        ticketDto.setTicketLost(false);
        ticketDto.setAmountDue(20);
    }

    @Test
    public void testGetTicketById() {
        when(ticketDao.getTicketById(anyInt())).thenReturn(ticketEntity);

        TicketDto ticketDto = ticketService.getTicketById(1);

        assertNotNull(ticketDto);
        assertEquals(1, ticketDto.getId());
    }

    @Test
    public void testGetAllTickets() {
        when(ticketDao.getAllTickets()).thenReturn(Arrays.asList(ticketEntity));

        List<TicketDto> ticketDto = ticketService.getAllTickets();

        assertNotNull(ticketDto);
        assertEquals(1, ticketDto.get(0).getId());
    }

    @Test
    public void testCreateTicket() {
        TicketDto ticketDto = ticketService.createTicket();

        assertNotNull(ticketDto);
    }

    @Test
    public void testUpdateTicket() {
        when(ticketDao.getTicketById(anyInt())).thenReturn(ticketEntity);

        TicketDto ticket = ticketService.updateTicket(ticketDto);

        assertNotNull(ticket);
        assertEquals(1, ticketDto.getId());
    }

}