package com.future.laboratories.service.impl;

import com.future.laboratories.entity.TicketEntity;
import com.future.laboratories.service.TicketService;
import com.future.laboratories.shared.dao.TicketDao;
import com.future.laboratories.shared.dao.impl.TicketDaoImpl;
import com.future.laboratories.shared.dto.TicketDto;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

}
