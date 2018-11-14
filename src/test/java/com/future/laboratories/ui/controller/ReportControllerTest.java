package com.future.laboratories.ui.controller;

import com.future.laboratories.service.impl.ReportServiceImpl;
import com.future.laboratories.shared.dto.ReportDto;
import com.future.laboratories.ui.model.response.report.RevenueMonthResponseModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;


public class ReportControllerTest {

    @InjectMocks
    ReportController reportController;

    @Mock
    ReportServiceImpl reportService;

    ReportDto reportDto;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        reportDto = new ReportDto();
        reportDto.setMonth(11);
        reportDto.setDay(12);
        reportDto.setRevenue(40);
        reportDto.setLost(0);
        reportDto.setMode(20);
    }

    @Test
    public void testGetReportByMonth() {
        when(reportService.getReportByMonth(anyInt())).thenReturn(reportDto);

        RevenueMonthResponseModel reportRest = reportController.getReportByMonth(11);

        assertNotNull(reportRest);
        assertEquals(reportDto.getMonth(), reportRest.getMonth());
    }

    @Test
    public void testGetReportByDay() {
        when(reportService.getReportByDay(anyInt(), anyInt())).thenReturn(reportDto);

        ReportDto reportRest = reportController.getReportByDay(11, 12);

        assertNotNull(reportRest);
        assertEquals(reportDto.getMonth(), reportRest.getMonth());
        assertEquals(reportDto.getDay(), reportRest.getDay());
    }

    @Test
    public void testGetLostTicketCount() {
        when(reportService.getLostTicketCount(anyInt(), anyInt())).thenReturn(reportDto);

        ReportDto reportRest = reportController.getLostTicketCount(11, 12);

        assertNotNull(reportRest);
        assertEquals(reportDto.getLost(), reportRest.getLost());
    }

    @Test
    public void testGetAmountDueMode() {
        when(reportService.getAmountDueMode(anyInt(), anyInt())).thenReturn(reportDto);

        ReportDto reportRest = reportController.getAmountDueMode(11, 12);

        assertNotNull(reportRest);
        assertEquals(reportDto.getMode(), reportRest.getMode());
    }
}