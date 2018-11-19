package com.future.laboratories.report.service;

import com.future.laboratories.report.dto.ReportDto;
import com.future.laboratories.report.dto.TimeDistributionDto;

/**
 * Interface to implemented for all report related presentation
 * layer and service layer objects.
 */
public interface ReportService {
    public ReportDto getReportByMonth(int month);
    public ReportDto getReportByDay(int month, int day);
    public ReportDto getReportByWeek(int week);
    public ReportDto getLostTicketCount(int month, int day);
    public ReportDto getAmountDueMode(int month, int day);
    public TimeDistributionDto getDistributionByCarLeaving(int month, int day);
    public TimeDistributionDto getDistributionByCarEntering(int month, int day);
}
