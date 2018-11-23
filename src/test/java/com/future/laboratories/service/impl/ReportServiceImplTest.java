/* COPYRIGHT © 2018 GARETH BOCK AND/OR ITS AFFILIATES. ALL RIGHTS RESERVED. */

package com.future.laboratories.service.impl;

import com.future.laboratories.ticket.entity.TicketEntity;
import com.future.laboratories.ticket.dao.impl.TicketDaoImpl;
import com.future.laboratories.report.dto.ReportDto;
import com.future.laboratories.report.dto.TimeDistributionDto;
import com.future.laboratories.report.service.impl.ReportServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

public class ReportServiceImplTest {

    @InjectMocks
    ReportServiceImpl reportService;

    @Mock
    TicketDaoImpl ticketDao;

    TicketEntity ticketEntity;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        ticketEntity = new TicketEntity();
        ticketEntity.setExitTime(LocalTime.of(11, 30));
        ticketEntity.setTicketDate(LocalDate.of(2018, 11, 12));
        ticketEntity.setEnterTime(LocalTime.of(10, 30));
        ticketEntity.setTicketLost(false);
        ticketEntity.setAmountDue(20);
    }

    @Test
    public void testGetReportByMonth() {
        when(ticketDao.getAllTicketsByMonth(anyInt())).thenReturn(Arrays.asList(ticketEntity));

        ReportDto reportDto = reportService.getReportByMonth(11);
        System.out.println(reportDto.toString());

        assertNotNull(reportDto);
        assertEquals(20, reportDto.getRevenue());
    }

    @Test
    public void testGetReportByDay() {
        when(ticketDao.getAllTicketsByDay(anyInt(), anyInt())).thenReturn(Arrays.asList(ticketEntity));

        ReportDto reportDto = reportService.getReportByDay(11, 12);

        assertNotNull(reportDto);
        assertEquals(20, reportDto.getRevenue());
    }

    @Test
    public void testGetReportByWeek() {
        when(ticketDao.getAllTickets()).thenReturn(Arrays.asList(ticketEntity));

        ReportDto reportDto = reportService.getReportByWeek(46);

        assertNotNull(reportDto);
        assertEquals(20, reportDto.getRevenue());
    }

    @Test
    public void testGetDistributionByCarEntering() {
        when(ticketDao.getAllTickets()).thenReturn(Arrays.asList(ticketEntity));

        TimeDistributionDto distributionDto = reportService.getDistributionByCarEntering(11, 12);

        assertNotNull(distributionDto);
    }

    @Test
    public void testGetDistributionByCarLeaving() {
        when(ticketDao.getAllTickets()).thenReturn(Arrays.asList(ticketEntity));

        TimeDistributionDto distributionDto = reportService.getDistributionByCarLeaving(11, 12);

        assertNotNull(distributionDto);
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