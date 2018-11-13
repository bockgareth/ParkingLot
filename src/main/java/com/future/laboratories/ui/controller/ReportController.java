package com.future.laboratories.ui.controller;

import com.future.laboratories.service.ReportService;
import com.future.laboratories.service.impl.ReportServiceImpl;
import com.future.laboratories.shared.dto.ReportDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/")
public class ReportController {

    ReportService reportService = new ReportServiceImpl();

    @GET
    @Path("/reports/{month}")
    @Produces(MediaType.APPLICATION_JSON)
    public ReportDto getReportByMonth(@PathParam("month") int month) {
        return reportService.getReportByMonth(month);
    }

    @GET
    @Path("/reports/{month}/{day}")
    @Produces(MediaType.APPLICATION_JSON)
    public ReportDto getReportByDay(@PathParam("month") int month, @PathParam("day") int day) {
        return reportService.getReportByDay(month, day);
    }

    @GET
    @Path("/reports/{month}/{day}/lost")
    @Produces(MediaType.APPLICATION_JSON)
    public ReportDto getLostTicketCount(@PathParam("month") int month, @PathParam("day") int day) {
        return reportService.getLostTicketCount(month, day);
    }

    @GET
    @Path("/reports/{month}/{day}/mode")
    @Produces(MediaType.APPLICATION_JSON)
    public ReportDto getAmountDueMode(@PathParam("month") int month, @PathParam("day") int day) {
        return reportService.getAmountDueMode(month, day);
    }

}