package com.future.laboratories.ui.controller;

import com.future.laboratories.service.impl.TicketServiceImpl;
import com.future.laboratories.shared.dto.TicketDto;
import com.future.laboratories.ui.model.request.ticket.UpdateTicketRequestModel;
import com.future.laboratories.ui.model.response.ticket.CreatedTicketResponseModel;
import com.future.laboratories.ui.model.response.ticket.TicketResponseModel;
import com.future.laboratories.ui.model.response.ticket.UpdatedTicketResponseModel;
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
    TicketController ticketController;

    @Mock
    TicketServiceImpl ticketService;

    TicketDto ticketDto;
    UpdateTicketRequestModel updateModel;

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

        updateModel = new UpdateTicketRequestModel();
        updateModel.setExitTime(LocalTime.of(12, 30));
        updateModel.setTicketLost(false);

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
        when(ticketService.createTicket()).thenReturn(ticketDto);

        CreatedTicketResponseModel ticketRest = ticketController.createTicket();

        assertNotNull(ticketRest);
        assertEquals(ticketDto.getEnterTime(), ticketRest.getEnterTime());
    }

    @Test
    public void testUpdateTicket() {
        when(ticketService.updateTicket(anyObject())).thenReturn(ticketDto);

        UpdatedTicketResponseModel ticketRest = ticketController.updateTicket(TICKET_ID, updateModel);

        assertNotNull(ticketRest);
        assertEquals(ticketDto.getEnterTime(), ticketRest.getEnterTime());
        assertEquals(ticketDto.getExitTime(), ticketRest.getExitTime());
        assertEquals(ticketDto.getAmountDue(), ticketRest.getAmountDue());
    }
}