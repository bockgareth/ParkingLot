package com.future.laboratories.ticket.dao.impl;

import com.future.laboratories.ticket.entity.TicketEntity;
import com.future.laboratories.ticket.dao.TicketDao;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * This class acts as the ticket data access object that generic
 * crud operations for ticket related queries.
 */
public class TicketDaoImpl extends JdbcDaoSupport implements TicketDao {

    private static final String GET_TICKET_BY_ID = "select * from ticket where id = ?";
    private static final String GET_ALL_TICKETS = "select * from ticket";
    private static final String CREATE_TICKET = "insert into ticket (id, ticket_date, ticket_enter_time, ticket_exit_time) values (next value for id, ?, ?, ?)";
    private static final String UPDATE_TICKET = "update ticket set ticket_exit_time = ?, is_ticket_lost = ?, amount_due = ? where id = ?";

    /**
     * Used to retrieve a single TicketEntity object based on its id.
     * @param id the id of a ticket that will be requested.
     * @return a TicketEntity that has been mapped to a Java object
     * from a SQL result set.
     */
    public TicketEntity getTicketById(int id) {
        return this.getJdbcTemplate().queryForObject(GET_TICKET_BY_ID, new Object[] {id}, new TicketMapper());
    }

    /**
     * Used to retrieve a TicketEntity List<E>.
     * @return TicketEntity List<E> that has been mapped to a List<E>
     * from a SQL result set.
     */
    public List<TicketEntity> getAllTickets() {
        return this.getJdbcTemplate().query(GET_ALL_TICKETS, new TicketMapper());
    }

    /**
     * Used to persist a TicketEntity to a database.
     * @param ticket a TicketEntity to be mapped to sql and inserted.
     */
    public void createTicket(TicketEntity ticket) {
        this.getJdbcTemplate().update(CREATE_TICKET, new Object[] {ticket.getTicketDate(), ticket.getEnterTime(), ticket.getExitTime()});
    }

    /**
     * Used to update a ticket was it is closed. Update statement
     * is made to a database.
     * @param ticket a TicketEntity to be mapped to sql and updated.
     */
    public void updateTicket(TicketEntity ticket) {
        this.getJdbcTemplate().update(UPDATE_TICKET, new Object[] {ticket.getExitTime(), ticket.isTicketLost(), ticket.getAmountDue(), ticket.getId()});
    }

    /**
     * This inner class acts as a mapper between SQL result sets
     * and Java objects.
     */
    private static final class TicketMapper implements RowMapper<TicketEntity> {

        @Override
        public TicketEntity mapRow(ResultSet resultSet, int i) throws SQLException {
            TicketEntity ticket = new TicketEntity();
            ticket.setId(resultSet.getInt("id"));
            ticket.setTicketDate(resultSet.getDate("ticket_date").toLocalDate());
            ticket.setEnterTime(resultSet.getTime("ticket_enter_time").toLocalTime());
            ticket.setExitTime(resultSet.getTime("ticket_exit_time").toLocalTime());
            ticket.setTicketLost(resultSet.getBoolean("is_ticket_lost"));
            ticket.setAmountDue(resultSet.getInt("amount_due"));
            return ticket;
        }
    }
}
