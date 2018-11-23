/* COPYRIGHT © 2018 GARETH BOCK AND/OR ITS AFFILIATES. ALL RIGHTS RESERVED. */

package com.future.laboratories.api.controller;

import com.future.laboratories.report.api.controller.impl.ReportControllerImpl;
import com.future.laboratories.report.api.model.*;
import com.future.laboratories.report.service.impl.ReportServiceImpl;
import com.future.laboratories.report.dto.ReportDto;
import com.future.laboratories.report.dto.TimeDistributionDto;
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
    ReportControllerImpl reportController;

    @Mock
    ReportServiceImpl reportService;

    ReportDto reportDto;
    TimeDistributionDto distributionDto;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        reportDto = new ReportDto();
        reportDto.setMonth(11);
        reportDto.setDay(12);
        reportDto.setRevenue(40);
        reportDto.setLost(0);
        reportDto.setMode(20);

        distributionDto = new TimeDistributionDto();
        distributionDto.setMonth(11);
        distributionDto.setDay(12);
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

        RevenueMonthDayResponseModel reportRest = reportController.getReportByDay(11, 12);

        assertNotNull(reportRest);
        assertEquals(reportDto.getMonth(), reportRest.getMonth());
        assertEquals(reportDto.getDay(), reportRest.getDay());
    }

    @Test
    public void testGetReportByWeek() {
        when(reportService.getReportByWeek(anyInt())).thenReturn(reportDto);

        RevenueWeekResponseModel reportRest = reportController.getReportByWeek(46);

        assertNotNull(reportRest);
        assertEquals(reportDto.getRevenue(), reportRest.getRevenue());
    }

    @Test
    public void tesGetDistributionByCarsEntering() {
        when(reportService.getDistributionByCarEntering(anyInt(), anyInt())).thenReturn(distributionDto);

        TimeDistributionResponseModel distributionResponseModel = reportController.getDistributionByCarsEntering(11, 12);

        assertNotNull(distributionResponseModel);
        assertEquals(distributionDto.getMonth(), distributionResponseModel.getMonth());
        assertEquals(distributionDto.getDay(), distributionResponseModel.getDay());
    }

    @Test
    public void testGetDistributionByCarsLeaving() {
        when(reportService.getDistributionByCarLeaving(anyInt(), anyInt())).thenReturn(distributionDto);

        TimeDistributionResponseModel distributionResponseModel = reportController.getDistributionByCarsLeaving(11, 12);

        assertNotNull(distributionResponseModel);
        assertEquals(distributionDto.getMonth(), distributionResponseModel.getMonth());
        assertEquals(distributionDto.getDay(), distributionResponseModel.getDay());
    }

    @Test
    public void testGetLostTicketCount() {
        when(reportService.getLostTicketCount(anyInt(), anyInt())).thenReturn(reportDto);

        LostTicketCountResponseModel reportRest = reportController.getLostTicketCount(11, 12);

        assertNotNull(reportRest);
        assertEquals(reportDto.getLost(), reportRest.getLost());
    }

    @Test
    public void testGetAmountDueMode() {
        when(reportService.getAmountDueMode(anyInt(), anyInt())).thenReturn(reportDto);

        PaymentModeResponseModel reportRest = reportController.getAmountDueMode(11, 12);

        assertNotNull(reportRest);
        assertEquals(reportDto.getMode(), reportRest.getMode());
    }
}