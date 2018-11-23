/* COPYRIGHT © 2018 GARETH BOCK AND/OR ITS AFFILIATES. ALL RIGHTS RESERVED. */

package com.future.laboratories.report.api.controller.impl;

import com.future.laboratories.report.api.controller.ReportController;
import com.future.laboratories.report.api.model.*;
import com.future.laboratories.report.service.ReportService;
import com.future.laboratories.report.service.impl.ReportServiceImpl;
import com.future.laboratories.report.dto.ReportDto;
import com.future.laboratories.report.dto.TimeDistributionDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * This class acts as the report controller that hosts HTTP endpoints
 * for report related queries.
 */
@Path("/reports")
public class ReportControllerImpl implements ReportController {

    /**
     * com.future.laboratories.report.service.impl.ReportServiceImpl to be injected.
     */
    ReportService reportService = new ReportServiceImpl();

    /**
     * GET (on 200 OK) request to retrieve a report summary for the specified
     * month.
     * @param month the month for the report to be generated on.
     * @return a {@link RevenueMonthResponseModel} as a response, output declared as json.
     */
    @GET
    @Path("/{month}")
    @Produces(MediaType.APPLICATION_JSON)
    public RevenueMonthResponseModel getReportByMonth(@PathParam("month") int month) {
        RevenueMonthResponseModel returnValue = new RevenueMonthResponseModel();

        ReportDto reportDto = reportService.getReportByMonth(month);

        returnValue.setMonth(month);
        returnValue.setRevenue(reportDto.getRevenue());

        return returnValue;
    }

    /**
     * GET (on 200 OK) request to retrieve a report summary for the specified
     * month and day.
     * @param month the month for the report to be generated on.
     * @param day the day for the report to be generated on.
     * @return a {@link RevenueMonthDayResponseModel} as a response, output declared as json.
     */
    @GET
    @Path("/{month}/{day}")
    @Produces(MediaType.APPLICATION_JSON)
    public RevenueMonthDayResponseModel getReportByDay(@PathParam("month") int month, @PathParam("day") int day) {
        RevenueMonthDayResponseModel returnValue = new RevenueMonthDayResponseModel();

        ReportDto reportDto = reportService.getReportByDay(month, day);

        returnValue.setMonth(month);
        returnValue.setDay(day);
        returnValue.setRevenue(reportDto.getRevenue());

        return returnValue;
    }

    /**
     * GET (on 200 OK) request to retrieve a report summary for the specified week.
     * @param week the week for the report to be generated on.
     * @return a {@link RevenueWeekResponseModel} as a response, output declared as json.
     */
    @GET
    @Path("/week/{week}")
    @Produces(MediaType.APPLICATION_JSON)
    public RevenueWeekResponseModel getReportByWeek(@PathParam("week") int week) {
        RevenueWeekResponseModel returnValue = new RevenueWeekResponseModel();

        ReportDto reportDto = reportService.getReportByWeek(week);

        returnValue.setWeek(week);
        returnValue.setRevenue(reportDto.getRevenue());

        return returnValue;
    }

    /**
     * GET (on 200 OK) request to retrieve a report summary for the time distribution
     * of cars entering on a specific day.
     * @param month the month for the report to be generated on.
     * @param day the day for the report to be generated on.
     * @return a {@link TimeDistributionResponseModel} as a response, output declared as json.
     */
    @GET
    @Path("/{month}/{day}/entering")
    @Produces(MediaType.APPLICATION_JSON)
    public TimeDistributionResponseModel getDistributionByCarsEntering(@PathParam("month") int month, @PathParam("day") int day) {
        TimeDistributionResponseModel returnValue = new TimeDistributionResponseModel();

        TimeDistributionDto distributionDto = reportService.getDistributionByCarEntering(month, day);

        returnValue.setMonth(month);
        returnValue.setDay(day);
        returnValue.setTime(distributionDto.getTimeMap());

        return returnValue;
    }

    /**
     * GET (on 200 OK) request to retrieve a report summary for the time distribution
     * of cars leaving on a specific day.
     * @param month the month for the report to be generated on.
     * @param day the day for the report to be generated on.
     * @return a {@link TimeDistributionResponseModel} as a response, output declared as json.
     */
    @GET
    @Path("{month}/{day}/leaving")
    @Produces(MediaType.APPLICATION_JSON)
    public TimeDistributionResponseModel getDistributionByCarsLeaving(@PathParam("month") int month, @PathParam("day") int day) {
        TimeDistributionResponseModel returnValue = new TimeDistributionResponseModel();

        TimeDistributionDto distributionDto = reportService.getDistributionByCarLeaving(month, day);

        returnValue.setMonth(month);
        returnValue.setDay(day);
        returnValue.setTime(distributionDto.getTimeMap());

        return returnValue;
    }

    /**
     * GET (on 200 OK) request to retrieve a report summary on how many
     * tickets were lost for the specified month and day.
     * @param month the month for the report to be generated on.
     * @param day the day for the report to be generated on.
     * @return a {@link LostTicketCountResponseModel} as a response, output declared as json.
     */
    @GET
    @Path("/{month}/{day}/lost")
    @Produces(MediaType.APPLICATION_JSON)
    public LostTicketCountResponseModel getLostTicketCount(@PathParam("month") int month, @PathParam("day") int day) {
        LostTicketCountResponseModel returnValue = new LostTicketCountResponseModel();

        ReportDto reportDto = reportService.getLostTicketCount(month, day);

        returnValue.setMonth(month);
        returnValue.setDay(day);
        returnValue.setLost(reportDto.getLost());

        return returnValue;
    }

    /**
     * GET (on 200 OK) request to retrieve a report summary with the mode
     * of payments due for the specified month and day.
     * @param month the month for the report to be generated on.
     * @param day the day for the report to be generated on.
     * @return a {@link PaymentModeResponseModel} as a response, output declared as json. Only supports
     * one mode. If there are mode conflicts, response will result in a 0.
     */
    @GET
    @Path("/{month}/{day}/mode")
    @Produces(MediaType.APPLICATION_JSON)
    public PaymentModeResponseModel getAmountDueMode(@PathParam("month") int month, @PathParam("day") int day) {
        PaymentModeResponseModel returnValue = new PaymentModeResponseModel();

        ReportDto reportDto = reportService.getAmountDueMode(month, day);

        returnValue.setMonth(month);
        returnValue.setDay(day);
        returnValue.setMode(reportDto.getMode());

        return returnValue;
    }

    /**
     * GET (on 200 OK) request to retrieve a report summary with number of
     * times the parking lot ran out of space during a specific day.
     * @param month the month for the report to be generated on.
     * @param day the day for the report to be generated on.
     * @return a {@link PaymentModeResponseModel} as a response, output declared as json. Only supports
     * one mode. If there are mode conflicts, response will result in a 0.
     */
    @GET
    @Path("/{month}/{day}/space")
    @Produces(MediaType.APPLICATION_JSON)
    public SpaceRanOutResponseModel getSpaceRanOut(@PathParam("month") int month, @PathParam("day") int day) {
        SpaceRanOutResponseModel returnValue = new SpaceRanOutResponseModel();

        ReportDto reportDto = reportService.getSpaceRanOut(month, day);

        returnValue.setMonth(month);
        returnValue.setDay(day);
        returnValue.setNoSpaceCount(reportDto.getSpaceRanOut());

        return returnValue;
    }
}