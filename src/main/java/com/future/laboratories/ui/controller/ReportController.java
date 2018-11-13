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

}