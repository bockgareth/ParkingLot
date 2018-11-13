package com.future.laboratories.service.impl;

import com.future.laboratories.entity.TicketEntity;
import com.future.laboratories.service.ReportService;
import com.future.laboratories.shared.dao.TicketDao;
import com.future.laboratories.shared.dao.impl.TicketDaoImpl;
import com.future.laboratories.shared.dto.ReportDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class ReportServiceImpl implements ReportService {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("databaseContext.xml");
    TicketDao ticketDao = ctx.getBean("ticketDao", TicketDaoImpl.class);

    public ReportDto getReportByMonth(int month) {
        ReportDto returnValue = new ReportDto();

        List<TicketEntity> tickets = ticketDao.getAllTickets();

        List<Integer> values = new ArrayList<>();

        for (TicketEntity ticket: tickets) {
            if (ticket.getTicketDate().getMonth().getValue() == month) {
                values.add(ticket.getAmountDue());
            }
        }

        returnValue.setRevenue(reduce(values));

        return returnValue;
    }

    public int reduce(List<Integer> values) {
        int sum = 0;
        for (int value: values) {
            sum += value;
        }
        return sum;
    }

}
