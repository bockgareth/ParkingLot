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


/**
 * The class acts an implementation for the Report Service. Performs
 * most of the business logic. Gets dto from presentation layer.
 */
public class ReportServiceImpl implements ReportService {

    /**
     * com.future.laboratories.shared.dao.impl.TicketDaoImpl to be injected.
     */
    TicketDao ticketDao = new TicketDaoImpl();

    /**
     * Service call to get a ReportDto containing report
     * information on the month.
     * @param month the month for getting the required lost
     * ticket count.
     * @return a ReportDto containing the revenue generated
     * for the month.
     */
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

    /**
     * Service call to get a ReportDto containing report
     * information on the day of the specified month.
     * @param month the month for getting the required lost
     * ticket count.
     * @param day the day for getting the required lost ticket
     * count.
     * @return a ReportDto containing the revenue generated
     * for the month and day.
     */
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

    /**
     * Service call to get the lost ticket count for the month
     * and day.
     * @param month the month for getting the required lost
     * ticket count.
     * @param day the day for getting the required lost ticket
     * count.
     * @return a ReportDto, containing the lost ticket count for the day.
     */
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

    /**
     * Service call to get a ReportDto containing report
     * information of the mode of all payments
     * @param month the month for getting the required mode.
     * @param day the day for getting the required mode.
     * @return a ReportDto, containing the mode of the list.
     */
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

    /**
     * Helper method to reduce a list to a single value. This
     * implementation sums up the values from a list.
     * @param values a list of values to be summed up.
     * @return sum of values from an list.
     */
    private int reduce(List<Integer> values) {
        int sum = 0;
        for (int value: values) {
            sum += value;
        }
        return sum;
    }

    /**
     * Helper method to reduce a list to a single value. This
     * implementation the mode from a list.
     * @param values a list of values to be calculated on.
     * @return the mode of the list.
     */
    private int mode(List<Integer> values) {
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
