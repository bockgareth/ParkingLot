package com.future.laboratories.ui.controller;

import com.future.laboratories.service.impl.TicketServiceImpl;
import com.future.laboratories.shared.dto.TicketDto;
import com.future.laboratories.ui.model.response.ticket.TicketResponseModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

public class TicketControllerTest {

    @InjectMocks
    TicketController ticketController;

    @Mock
    TicketServiceImpl ticketService;

    TicketDto ticketDto;

    final int TICKET_ID = 1;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        ticketDto = new TicketDto();
        ticketDto.setTicketId(TICKET_ID);
        ticketDto.setTicketDate(LocalDate.of(2018, 11, 12));
        ticketDto.setEnterTime(LocalTime.of(10, 30));
        ticketDto.setExitTime(LocalTime.of(11, 30));
        ticketDto.setTicketLost(false);
        ticketDto.setAmountDue(20);
    }

    @Test
    public void testGetAllTickets() {
        when(ticketService.getAllTickets()).thenReturn(Arrays.asList(ticketDto, new TicketDto()));

        List<TicketResponseModel> ticketRest = ticketController.getAllTickets();

        assertNotNull(ticketRest);
        assertEquals(TICKET_ID, ticketRest.get(0).getTicketId());
        assertEquals(ticketDto.getEnterTime(), ticketRest.get(0).getEnterTime());
        assertEquals(ticketDto.getExitTime(), ticketRest.get(0).getExitTime());
    }

    @Test
    public void testGetTicketById() {
        when(ticketService.getTicketById(anyInt())).thenReturn(ticketDto);

        TicketResponseModel ticketRest = ticketController.getTicketById(TICKET_ID);

        assertNotNull(ticketRest);
        assertEquals(TICKET_ID, ticketRest.getTicketId());
        assertEquals(ticketDto.getEnterTime(), ticketRest.getEnterTime());
        assertEquals(ticketDto.getExitTime(), ticketRest.getExitTime());
        assertEquals(ticketDto.getAmountDue(), ticketRest.getAmountDue());
    }

    @Test
    public void testCreateTicket() {
        when(ticketService.createTicket(anyObject())).thenReturn(ticketDto);

        TicketDto ticketRest = ticketController.createTicket(ticketDto);

        assertNotNull(ticketRest);
        assertEquals(ticketDto.getEnterTime(), ticketRest.getEnterTime());
        assertEquals(ticketDto.getExitTime(), ticketRest.getExitTime());
        assertEquals(ticketDto.getAmountDue(), ticketRest.getAmountDue());
    }

    @Test
    public void testUpdateTicket() {
        when(ticketService.updateTicket(anyInt(), anyObject())).thenReturn(ticketDto);

        TicketDto ticketRest = ticketController.updateTicket(TICKET_ID, ticketDto);

        assertNotNull(ticketRest);
        assertEquals(ticketDto.getEnterTime(), ticketRest.getEnterTime());
        assertEquals(ticketDto.getExitTime(), ticketRest.getExitTime());
        assertEquals(ticketDto.getAmountDue(), ticketRest.getAmountDue());
    }
}