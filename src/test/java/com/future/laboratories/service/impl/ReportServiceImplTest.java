package com.future.laboratories.service.impl;

import com.future.laboratories.entity.TicketEntity;
import com.future.laboratories.shared.dao.impl.TicketDaoImpl;
import com.future.laboratories.shared.dto.ReportDto;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ReportServiceImplTest {

    @InjectMocks
    ReportServiceImpl reportService;

    @Mock
    TicketDaoImpl ticketDao;

    TicketEntity ticketEntity;

    final int TICKET_ID = 1;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        ticketEntity = new TicketEntity();
        ticketEntity.setTicketId(TICKET_ID);
        ticketEntity.setExitTime(LocalTime.of(11, 30));
        ticketEntity.setTicketDate(LocalDate.of(2018, 11, 12));
        ticketEntity.setEnterTime(LocalTime.of(10, 30));
        ticketEntity.setTicketLost(false);
        ticketEntity.setAmountDue(20);
    }

    @Test
    public void testGetReportByMonth() {
        when(ticketDao.getAllTickets()).thenReturn(Arrays.asList(ticketEntity));

        ReportDto reportDto = reportService.getReportByMonth(11);

        assertNotNull(reportDto);
        assertEquals(20, reportDto.getRevenue());
    }

    @Test
    public void testGetReportByDay() {
        when(ticketDao.getAllTickets()).thenReturn(Arrays.asList(ticketEntity));

        ReportDto reportDto = reportService.getReportByDay(11, 12);

        assertNotNull(reportDto);
        assertEquals(20, reportDto.getRevenue());
    }

    @Test
    public void testGetLostTicketCount() {
        when(ticketDao.getAllTickets()).thenReturn(Arrays.asList(ticketEntity));

        ReportDto reportDto = reportService.getLostTicketCount(11, 12);

        assertNotNull(reportDto);
        assertEquals(0, reportDto.getLost());
    }

    @Test
    public void testGetAmountDueMode() {
        when(ticketDao.getAllTickets()).thenReturn(Arrays.asList(ticketEntity));

        ReportDto reportDto = reportService.getAmountDueMode(11, 12);

        assertNotNull(reportDto);
        assertEquals(0, reportDto.getMode());
    }
}