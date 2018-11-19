package com.future.laboratories.api.controller;

import com.future.laboratories.ticket.service.impl.TicketServiceImpl;
import com.future.laboratories.ticket.dto.TicketDto;
import com.future.laboratories.ticket.api.model.CreatedTicketResponseModel;
import com.future.laboratories.ticket.api.model.TicketResponseModel;
import com.future.laboratories.ticket.api.controller.impl.TicketControllerImpl;
import org.junit.Before;
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
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

public class TicketControllerTest {

    @InjectMocks
    TicketControllerImpl ticketController;

    @Mock
    TicketServiceImpl ticketService;

    TicketDto ticketDto;
    TicketResponseModel updateModel;

    final int TICKET_ID = 1;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        ticketDto = new TicketDto();
        ticketDto.setId(TICKET_ID);
        ticketDto.setTicketDate(LocalDate.of(2018, 11, 12));
        ticketDto.setEnterTime(LocalTime.of(10, 30));
        ticketDto.setExitTime(LocalTime.of(11, 30));
        ticketDto.setTicketLost(false);
        ticketDto.setAmountDue(20);

        updateModel = new TicketResponseModel();
        updateModel.setExitTime(LocalTime.of(12, 30));
        updateModel.setTicketLost(false);

    }

    @Test
    public void testGetAllTickets() {
        when(ticketService.getAllTickets()).thenReturn(Arrays.asList(ticketDto, new TicketDto()));

        List<TicketResponseModel> ticketRest = ticketController.getAllTickets();

        assertNotNull(ticketRest);
        assertEquals(TICKET_ID, ticketRest.get(0).getId());
        assertEquals(ticketDto.getEnterTime(), ticketRest.get(0).getEnterTime());
        assertEquals(ticketDto.getExitTime(), ticketRest.get(0).getExitTime());
    }

    @Test
    public void testGetTicketById() {
        when(ticketService.getTicketById(anyInt())).thenReturn(ticketDto);

        TicketResponseModel ticketRest = ticketController.getTicketById(TICKET_ID);

        assertNotNull(ticketRest);
        assertEquals(TICKET_ID, ticketRest.getId());
        assertEquals(ticketDto.getEnterTime(), ticketRest.getEnterTime());
        assertEquals(ticketDto.getExitTime(), ticketRest.getExitTime());
        assertEquals(ticketDto.getAmountDue(), ticketRest.getAmountDue());
    }

    @Test
    public void testCreateTicket() {
        when(ticketService.createTicket()).thenReturn(ticketDto);

        CreatedTicketResponseModel ticketRest = ticketController.createTicket();

        assertNotNull(ticketRest);
        assertEquals(ticketDto.getEnterTime(), ticketRest.getEnterTime());
    }

    @Test
    public void testUpdateTicket() {
        when(ticketService.updateTicket(anyObject())).thenReturn(ticketDto);

        TicketResponseModel ticketRest = ticketController.updateTicket(TICKET_ID, updateModel);

        assertNotNull(ticketRest);
        assertEquals(ticketDto.getEnterTime(), ticketRest.getEnterTime());
        assertEquals(ticketDto.getExitTime(), ticketRest.getExitTime());
        assertEquals(ticketDto.getAmountDue(), ticketRest.getAmountDue());
    }
}