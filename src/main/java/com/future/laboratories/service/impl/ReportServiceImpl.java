package com.future.laboratories.service.impl;

import com.future.laboratories.entity.TicketEntity;
import com.future.laboratories.service.ReportService;
import com.future.laboratories.shared.dao.TicketDao;
import com.future.laboratories.shared.dao.impl.TicketDaoImpl;
import com.future.laboratories.shared.dto.ReportDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
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

    public ReportDto getReportByDay(int month, int day) {
        ReportDto returnValue = new ReportDto();

        List<TicketEntity> tickets = ticketDao.getAllTickets();

        List<Integer> values = new ArrayList<>();

        for (TicketEntity ticket: tickets) {
            if (ticket.getTicketDate().getMonth().getValue() == month && ticket.getTicketDate().getDayOfMonth() == day) {
                values.add(ticket.getAmountDue());
            }
        }

        returnValue.setRevenue(reduce(values));

        return returnValue;
    }

    public ReportDto getLostTicketCount(int month, int day) {
        ReportDto returnValue = new ReportDto();

        List<TicketEntity> tickets = ticketDao.getAllTickets();

        int lostTicketCount = 0;

        for (TicketEntity ticket: tickets) {
            if (ticket.getTicketDate().getMonth().getValue() == month && ticket.getTicketDate().getDayOfMonth() == day) {
                if (ticket.isTicketLost()) {
                    lostTicketCount++;
                }
            }
        }

        returnValue.setLost(lostTicketCount);

        return returnValue;
    }

    public ReportDto getAmountDueMode(int month, int day) {
        ReportDto returnValue = new ReportDto();

        List<TicketEntity> tickets = ticketDao.getAllTickets();

        List<Integer> values = new ArrayList<>();

        for (TicketEntity ticket: tickets) {
            if (ticket.getTicketDate().getMonth().getValue() == month && ticket.getTicketDate().getDayOfMonth() == day) {
                values.add(ticket.getAmountDue());
            }
        }

        returnValue.setMode(mode(values));

        return returnValue;
    }

    public int reduce(List<Integer> values) {
        int sum = 0;
        for (int value: values) {
            sum += value;
        }
        return sum;
    }

    public int mode(List<Integer> values) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int max  = 1;
        int temp = 0;

        for(int value: values) {
            if (hashMap.get(value) != null) {
                int count = hashMap.get(value);

                count++;
                hashMap.put(value, count);

                if(count > max) {
                    max  = count;
                    temp = value;
                }
            } else {
                hashMap.put(value, 1);
            }
        }
        return temp;
    }

}
