/* COPYRIGHT © 2018 GARETH BOCK AND/OR ITS AFFILIATES. ALL RIGHTS RESERVED. */

package com.future.laboratories.report.api.controller;

import com.future.laboratories.report.api.model.*;

public interface ReportController {

    public RevenueMonthResponseModel getReportByMonth(int month);
    public RevenueMonthDayResponseModel getReportByDay(int month, int day);
    public RevenueWeekResponseModel getReportByWeek(int week);
    public TimeDistributionResponseModel getDistributionByCarsEntering(int month, int day);
    public TimeDistributionResponseModel getDistributionByCarsLeaving(int month, int day);
    public LostTicketCountResponseModel getLostTicketCount(int month, int day);
    public PaymentModeResponseModel getAmountDueMode(int month, int day);
    public SpaceRanOutResponseModel getSpaceRanOut(int month, int day);

}
