package com.future.laboratories.service;

import com.future.laboratories.shared.dto.ReportDto;

public interface ReportService {
    public ReportDto getReportByMonth(int month);
    public ReportDto getReportByDay(int month, int day);
    public ReportDto getLostTicketCount(int month, int day);
}
