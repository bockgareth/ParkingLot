package com.future.laboratories.ticket.service.impl;

import com.future.laboratories.domain.Fee;
import com.future.laboratories.domain.impl.FeeStructureImpl;
import com.future.laboratories.ticket.entity.TicketEntity;
import com.future.laboratories.ticket.service.TicketService;
import com.future.laboratories.ticket.dao.TicketDao;
import com.future.laboratories.ticket.dao.impl.TicketDaoImpl;
import com.future.laboratories.ticket.dto.TicketDto;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * The class acts as an implementation for the Ticket Service. Performs
 * most of the business logic. Gets dto from presentation layer.
 */
public class TicketServiceImpl implements TicketService {

    /**
     * com.future.laboratories.ticket.dao.impl.TicketDaoImpl to be injected.
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
     * @return a TicketDto to be return to the client.
     */
    public TicketDto createTicket() {
        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setTicketDate(LocalDate.now());
        ticketEntity.setEnterTime(LocalTime.now());
        ticketEntity.setExitTime(LocalTime.of(0, 0, 0));

        ticketDao.createTicket(ticketEntity);

        TicketDto returnValue = new TicketDto();
        BeanUtils.copyProperties(ticketEntity, returnValue);

        return returnValue;
    }

    /**
     * Used to update a TicketEntity and send to a ticket dao.
     * @param ticket a TicketDto to be updated.
     * @return a TicketDto to be return to the client.
     */
    public TicketDto updateTicket(TicketDto ticket) {
        TicketEntity ticketEntity = ticketDao.getTicketById(ticket.getId());
        ticketEntity.setExitTime(ticket.getExitTime());
        ticketEntity.setTicketLost(ticket.isTicketLost());

        int amountDue = calculateAmountDue(ticketEntity);

        ticketEntity.setAmountDue(amountDue);

        if (ticket.getTicketDate().getDayOfYear() != ticketEntity.getTicketDate().getDayOfYear()) {
            ticketEntity.setAmountDue(100);
        }

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
        List<Fee> feeList = new ArrayList<>();
        feeList.add(new Fee(0, 29, 10));
        feeList.add(new Fee(30, 59, 20));
        feeList.add(new Fee(60, 119, 30));
        feeList.add(new Fee(120, 239, 50));
        feeList.add(new Fee(240, 100));

        FeeStructureImpl fees = new FeeStructureImpl(150, feeList);

        if (ticket.isTicketLost()) {
            return fees.getLostFee();
        }

        long minuteDifference = Duration.between(ticket.getEnterTime(), ticket.getExitTime()).toMinutes();
        return calculateMinuteDifferenceAmountDue(fees, minuteDifference);
    }

    /**
     * Used to calculate the amount due based on the time difference.
     * @param m the time difference in minutes.
     * @return the payment due.
     */
    private int calculateMinuteDifferenceAmountDue(FeeStructureImpl structure, long m) {
        return structure.calculateFee(m);
    }

}
