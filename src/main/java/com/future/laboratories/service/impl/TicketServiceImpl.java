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

/**
 * The class acts as an implementation for the Ticket Service. Performs
 * most of the business logic. Gets dto from presentation layer.
 */
public class TicketServiceImpl implements TicketService {

    /**
     * com.future.laboratories.shared.dao.impl.TicketDaoImpl to be injected.
     */
    ApplicationContext ctx = new ClassPathXmlApplicationContext("databaseContext.xml");
    TicketDao ticketDao = ctx.getBean("ticketDao", TicketDaoImpl.class);

    /**
     * Used to retrieve a single TicketEntity object based on its id
     * from a ticket dao.
     * @param id the id of a ticket that will be requested.
     * @return a TicketDto to be return to the client.
     */
    public TicketDto getTicketById(int id) {
        TicketEntity ticket = ticketDao.getTicketById(id);

        TicketDto returnValue = new TicketDto();
        BeanUtils.copyProperties(ticket, returnValue);

        return returnValue;
    }

    /**
     * Used to retrieve a TicketEntity List<E> from a ticket dao.
     * @return a TicketDto List<E> to be return to the client.
     */
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

    /**
     * Used to create a TicketEntity and send to a ticket dao.
     * @param ticket a TicketDto to be created.
     * @return a TicketDto to be return to the client.
     */
    public TicketDto createTicket(TicketDto ticket) {
        TicketEntity ticketEntity = new TicketEntity();
        BeanUtils.copyProperties(ticket, ticketEntity);

        ticketDao.createTicket(ticketEntity);

        TicketDto returnValue = new TicketDto();
        BeanUtils.copyProperties(ticketEntity, returnValue);

        return returnValue;
    }

    /**
     * Used to update a TicketEntity and send to a ticket dao.
     * @param id the id of a ticket that will be requested.
     * @param ticket a TicketDto to be updated.
     * @return a TicketDto to be return to the client.
     */
    public TicketDto updateTicket(int id, TicketDto ticket) {
        TicketEntity ticketEntity = ticketDao.getTicketById(id);
        ticketEntity.setExitTime(ticket.getExitTime());
        ticketEntity.setTicketLost(ticket.isTicketLost());

        int amountDue = calculateAmountDue(ticketEntity);
        ticketEntity.setAmountDue(amountDue);

        ticketDao.updateTicket(ticketEntity);

        TicketDto returnValue = new TicketDto();
        BeanUtils.copyProperties(ticketEntity, returnValue);

        return returnValue;
    }

    /**
     * Used to calculate the amount due for the specified TicketEntity.
     * @param ticket TicketEntity to used calculate amount due for.
     * @return 100 if the ticket is lost.
     * @return the payment due if <calculateMinuteDifferenceAmountDue> is reached.
     */
    private int calculateAmountDue(TicketEntity ticket) {
        if (ticket.isTicketLost()) {
            return 100;
        }

        long minuteDifference = Duration.between(ticket.getEnterTime(), ticket.getExitTime()).toMinutes();
        return calculateMinuteDifferenceAmountDue(minuteDifference);
    }

    /**
     * Used to calculate the amount due based on the time difference.
     * @param m the time difference in minutes.
     * @return the payment due.
     */
    private int calculateMinuteDifferenceAmountDue(long m) {
        if (m >= 0 && m < 30) return 10;
        else if (m >= 30 && m < 60) return 20;
        else if (m >= 60 && m < 120) return 30;
        else if (m >= 120 && m < 240) return 50;
        else return 100;
    }

}
