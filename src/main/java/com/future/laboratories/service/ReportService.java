package com.future.laboratories.service;

import com.future.laboratories.shared.dto.ReportDto;

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
}
