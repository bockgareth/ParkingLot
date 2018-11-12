package com.future.laboratories.service.impl;

import com.future.laboratories.entity.TicketEntity;
import com.future.laboratories.service.TicketService;
import com.future.laboratories.shared.dao.TicketDao;
import com.future.laboratories.shared.dao.impl.TicketDaoImpl;
import com.future.laboratories.shared.dto.TicketDto;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TicketServiceImpl implements TicketService {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("databaseContext.xml");
    TicketDao ticketDao = ctx.getBean("ticketDao", TicketDaoImpl.class);

    public TicketDto getTicketById(int id) {
        TicketEntity ticket = ticketDao.getTicketById(id);

        TicketDto returnValue = new TicketDto();
        BeanUtils.copyProperties(ticket, returnValue);

        return returnValue;
    }

    public List<TicketDto> getAllTickets() {
        List<TicketDto> returnValue = new ArrayList<>();

        List<TicketEntity> tickets = ticketDao.getAllTickets();

        for (TicketEntity ticketEntity: tickets) {
            TicketDto ticketDto = new TicketDto();
            BeanUtils.copyProperties(ticketEntity, ticketDto);
            returnValue.add(ticketDto);
        }

        return returnValue;
    }


    public TicketDto createTicket(TicketDto ticket) {
        TicketEntity ticketEntity = new TicketEntity();
        BeanUtils.copyProperties(ticket, ticketEntity);

        ticketDao.createTicket(ticketEntity);

        TicketDto returnValue = new TicketDto();
        BeanUtils.copyProperties(ticketEntity, returnValue);

        return returnValue;
    }

    public TicketDto updateTicket(int id, TicketDto ticket) {
        TicketEntity ticketEntity = ticketDao.getTicketById(id);
        BeanUtils.copyProperties(ticket, ticketEntity);

        int amountDue = calculateAmountDue(ticketEntity);
        ticketEntity.setAmountDue(amountDue);

        ticketDao.updateTicket(ticketEntity);

        TicketDto returnValue = new TicketDto();
        BeanUtils.copyProperties(ticketEntity, returnValue);

        return returnValue;
    }

    public int calculateAmountDue(TicketEntity ticket) {
        if (ticket.isTicketLost()) {
            return 100;
        }

        long minuteDifference = Duration.between(ticket.getEnterTime(), ticket.getExitTime()).toMinutes();
        return calculateMinuteDifferenceAmountDue(minuteDifference);
    }

    public int calculateMinuteDifferenceAmountDue(long m) {
        if (m >= 0 && m < 30) return 10;
        else if (m >= 30 && m < 60) return 20;
        else if (m >= 60 && m < 120) return 30;
        else if (m >= 120 && m < 240) return 50;
        else return 100;
    }

}
