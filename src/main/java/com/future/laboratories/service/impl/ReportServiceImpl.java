package com.future.laboratories.service.impl;

import com.future.laboratories.entity.TicketEntity;
import com.future.laboratories.service.ReportService;
import com.future.laboratories.shared.dao.TicketDao;
import com.future.laboratories.shared.dao.impl.TicketDaoImpl;
import com.future.laboratories.shared.dto.ReportDto;
import com.future.laboratories.shared.dto.TimeDistributionDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalTime;
import java.time.temporal.WeekFields;
import java.util.*;


/**
 * The class acts an implementation for the Report Service. Performs
 * most of the business logic. Gets dto from presentation layer.
 */
public class ReportServiceImpl implements ReportService {

    /**
     * com.future.laboratories.shared.dao.impl.TicketDaoImpl to be injected.
     */
    ApplicationContext ctx = new ClassPathXmlApplicationContext("databaseContext.xml");
    TicketDao ticketDao = ctx.getBean("ticketDao", TicketDaoImpl.class);

    /**
     * Service call to get a ReportDto containing report
     * information on the month.
     * @param month the month for getting the required report
     * information.
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
     * @param month the month for getting the required report
     * information.
     * @param day the day for getting the required report
     * information.
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
     * Service call to get a ReportDto containing report
     * information for the specified week of the year.
     * @param week the week of the year for getting the required report
     * information.
     * @return a ReportDto containing the revenue generated
     * for the week.
     */
    public ReportDto getReportByWeek(int week) {
        ReportDto returnValue = new ReportDto();

        List<TicketEntity> tickets = ticketDao.getAllTickets();

        List<Integer> values = new ArrayList<>();

        for (TicketEntity ticket: tickets) {
            if (ticket.getTicketDate().get(WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear()) == week) {
                values.add(ticket.getAmountDue());
            }
        }

        returnValue.setRevenue(reduce(values));

        return returnValue;
    }

    /**
     * Service call to get a TimeDistributionDto containing report
     * information on the day of the specified month.
     * @param month the month for getting the required report
     * information.
     * @param day the day for getting the required report
     * information.
     * @return a TimeDistributionDto containing the time distribution
     * for cars entering the complex.
     */
    public TimeDistributionDto getDistributionByCarEntering(int month, int day) {
        TimeDistributionDto returnValue = new TimeDistributionDto();

        List<TicketEntity> tickets = ticketDao.getAllTickets();

        for (TicketEntity ticket: tickets) {
            if (ticket.getTicketDate().getMonth().getValue() == month && ticket.getTicketDate().getDayOfMonth() == day) {
                if (ticket.getEnterTime().isAfter(LocalTime.parse("09:00:00")) && ticket.getEnterTime().isBefore(LocalTime.parse("09:29:00"))) returnValue.setNine(returnValue.getNine() + 1);
                if (ticket.getEnterTime().isAfter(LocalTime.parse("09:30:00")) && ticket.getEnterTime().isBefore(LocalTime.parse("09:59:00"))) returnValue.setNineThirty(returnValue.getNineThirty() + 1);
                if (ticket.getEnterTime().isAfter(LocalTime.parse("10:00:00")) && ticket.getEnterTime().isBefore(LocalTime.parse("10:29:00"))) returnValue.setTen(returnValue.getTen() + 1);
                if (ticket.getEnterTime().isAfter(LocalTime.parse("10:30:00")) && ticket.getEnterTime().isBefore(LocalTime.parse("10:59:00"))) returnValue.setTenThirty(returnValue.getTenThirty() + 1);
                if (ticket.getEnterTime().isAfter(LocalTime.parse("11:00:00")) && ticket.getEnterTime().isBefore(LocalTime.parse("11:29:00"))) returnValue.setEleven(returnValue.getEleven() + 1);
                if (ticket.getEnterTime().isAfter(LocalTime.parse("11:30:00")) && ticket.getEnterTime().isBefore(LocalTime.parse("11:59:00"))) returnValue.setElevenThirty(returnValue.getElevenThirty() + 1);
                if (ticket.getEnterTime().isAfter(LocalTime.parse("12:00:00")) && ticket.getEnterTime().isBefore(LocalTime.parse("12:29:00"))) returnValue.setTwelve(returnValue.getTwelve() + 1);
                if (ticket.getEnterTime().isAfter(LocalTime.parse("12:30:00")) && ticket.getEnterTime().isBefore(LocalTime.parse("12:59:00"))) returnValue.setTwelveThirty(returnValue.getTwelveThirty() + 1);
                if (ticket.getEnterTime().isAfter(LocalTime.parse("13:00:00")) && ticket.getEnterTime().isBefore(LocalTime.parse("13:29:00"))) returnValue.setThirteen(returnValue.getThirteen() + 1);
                if (ticket.getEnterTime().isAfter(LocalTime.parse("13:30:00")) && ticket.getEnterTime().isBefore(LocalTime.parse("13:59:00"))) returnValue.setThirteenThirty(returnValue.getThirteenThirty() + 1);
                if (ticket.getEnterTime().isAfter(LocalTime.parse("14:00:00")) && ticket.getEnterTime().isBefore(LocalTime.parse("14:29:00"))) returnValue.setFourteen(returnValue.getFourteen() + 1);
                if (ticket.getEnterTime().isAfter(LocalTime.parse("14:30:00")) && ticket.getEnterTime().isBefore(LocalTime.parse("14:59:00"))) returnValue.setFourteenThirty(returnValue.getFourteenThirty() + 1);
                if (ticket.getEnterTime().isAfter(LocalTime.parse("15:00:00")) && ticket.getEnterTime().isBefore(LocalTime.parse("15:29:00"))) returnValue.setFifteen(returnValue.getFifteen() + 1);
            }
        }

        returnValue.setTimeMap(setTimeMap(returnValue));

        return returnValue;
    }

    /**
     *
     * @param month the month for getting the required report
     * information.
     * @param day the day for getting the required report
     * information.
     * @return a TimeDistributionDto containing the time distribution
     * for cars leaving the complex.
     */
    public TimeDistributionDto getDistributionByCarLeaving(int month, int day) {
        TimeDistributionDto returnValue = new TimeDistributionDto();

        List<TicketEntity> tickets = ticketDao.getAllTickets();

        Map<String, Integer> time = new HashMap<>();

        for (TicketEntity ticket: tickets) {
            if (ticket.getTicketDate().getMonth().getValue() == month && ticket.getTicketDate().getDayOfMonth() == day) {
                if (ticket.getExitTime().isAfter(LocalTime.parse("09:00:00")) && ticket.getExitTime().isBefore(LocalTime.parse("09:29:00"))) returnValue.setNine(returnValue.getNine() + 1);
                if (ticket.getExitTime().isAfter(LocalTime.parse("09:30:00")) && ticket.getExitTime().isBefore(LocalTime.parse("09:59:00"))) returnValue.setNineThirty(returnValue.getNineThirty() + 1);
                if (ticket.getExitTime().isAfter(LocalTime.parse("10:00:00")) && ticket.getExitTime().isBefore(LocalTime.parse("10:29:00"))) returnValue.setTen(returnValue.getTen() + 1);
                if (ticket.getExitTime().isAfter(LocalTime.parse("10:30:00")) && ticket.getExitTime().isBefore(LocalTime.parse("10:59:00"))) returnValue.setTenThirty(returnValue.getTenThirty() + 1);
                if (ticket.getExitTime().isAfter(LocalTime.parse("11:00:00")) && ticket.getExitTime().isBefore(LocalTime.parse("11:29:00"))) returnValue.setEleven(returnValue.getEleven() + 1);
                if (ticket.getExitTime().isAfter(LocalTime.parse("11:30:00")) && ticket.getExitTime().isBefore(LocalTime.parse("11:59:00"))) returnValue.setElevenThirty(returnValue.getElevenThirty() + 1);
                if (ticket.getExitTime().isAfter(LocalTime.parse("12:00:00")) && ticket.getExitTime().isBefore(LocalTime.parse("12:29:00"))) returnValue.setTwelve(returnValue.getTwelve() + 1);
                if (ticket.getExitTime().isAfter(LocalTime.parse("12:30:00")) && ticket.getExitTime().isBefore(LocalTime.parse("12:59:00"))) returnValue.setTwelveThirty(returnValue.getTwelveThirty() + 1);
                if (ticket.getExitTime().isAfter(LocalTime.parse("13:00:00")) && ticket.getExitTime().isBefore(LocalTime.parse("13:29:00"))) returnValue.setThirteen(returnValue.getThirteen() + 1);
                if (ticket.getExitTime().isAfter(LocalTime.parse("13:30:00")) && ticket.getExitTime().isBefore(LocalTime.parse("13:59:00"))) returnValue.setThirteenThirty(returnValue.getThirteenThirty() + 1);
                if (ticket.getExitTime().isAfter(LocalTime.parse("14:00:00")) && ticket.getExitTime().isBefore(LocalTime.parse("14:29:00"))) returnValue.setFourteen(returnValue.getFourteen() + 1);
                if (ticket.getExitTime().isAfter(LocalTime.parse("14:30:00")) && ticket.getExitTime().isBefore(LocalTime.parse("14:59:00"))) returnValue.setFourteenThirty(returnValue.getFourteenThirty() + 1);
                if (ticket.getExitTime().isAfter(LocalTime.parse("15:00:00")) && ticket.getExitTime().isBefore(LocalTime.parse("15:29:00"))) returnValue.setFifteen(returnValue.getFifteen() + 1);
            }
        }

        returnValue.setTimeMap(setTimeMap(returnValue));

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
            if (ticket.getTicketDate().getMonth().getValue() == month && ticket.getTicketDate().getDayOfMonth() == day && ticket.isTicketLost()) {
                lostTicketCount++;
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

    /**
     * Helper method to convert all the properties of
     * a TimeDistributionDto to a HashMap.
     * @param dto the TimeDistributionDto that has properties to
     * be converted.
     * @return the set HashMap.
     */
    private Map setTimeMap(TimeDistributionDto dto) {
        Map<String, Integer> time = new HashMap<>();
        time.put("09:00", dto.getNine());
        time.put("09:30", dto.getNineThirty());
        time.put("10:00", dto.getTen());
        time.put("10:30", dto.getTenThirty());
        time.put("11:00", dto.getEleven());
        time.put("11:30", dto.getElevenThirty());
        time.put("12:00", dto.getTwelve());
        time.put("12:30", dto.getTwelveThirty());
        time.put("13:00", dto.getThirteen());
        time.put("13:30", dto.getThirteenThirty());
        time.put("14:00", dto.getFourteen());
        time.put("14:30", dto.getFourteenThirty());
        time.put("15:00", dto.getFifteen());
        dto.setTimeMap(time);
        return dto.getTimeMap();
    }

}
