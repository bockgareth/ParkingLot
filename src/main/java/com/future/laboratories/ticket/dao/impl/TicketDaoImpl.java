package com.future.laboratories.ticket.dao.impl;

import com.future.laboratories.ticket.entity.TicketEntity;
import com.future.laboratories.ticket.dao.TicketDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * This class acts as the ticket data access object that generic
 * crud operations for ticket related queries.
 */
public class TicketDaoImpl implements TicketDao {

    private static final String GET_TICKET_BY_ID = "select id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due from ticket where id = ?";
    private static final String GET_ALL_TICKETS = "select id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due from ticket";
    private static final String GET_ALL_TICKETS_BY_MONTH = "select id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due from ticket where month(ticket_date) = ?";
    private static final String GET_ALL_TICKETS_BY_DAY = "select id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due from ticket where month(ticket_date) = ? and day(ticket_date) = ?";
    private static final String CREATE_TICKET = "insert into ticket (id, ticket_date, ticket_enter_time, ticket_exit_time) values (next value for id, ?, ?, ?)";
    private static final String UPDATE_TICKET = "update ticket set ticket_exit_time = ?, is_ticket_lost = ?, amount_due = ? where id = ?";

    private JdbcTemplate jdbcTemplate;

    public TicketDaoImpl() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
        dataSource.setUrl("jdbc:hsqldb:mem:pool");
        dataSource.setUsername("sa");
        dataSource.setPassword("root");
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * Used to retrieve a single {@link TicketEntity} object based on its id.
     * @param id the id of a ticket that will be requested.
     * @return a TicketEntity that has been mapped to a Java object
     * from a SQL result set.
     */
    public TicketEntity getTicketById(int id) {
        return jdbcTemplate.queryForObject(GET_TICKET_BY_ID, new Object[] {id}, new TicketMapper());
    }

    /**
     * Used to retrieve a TicketEntity List<E>.
     * @return TicketEntity List<E> that has been mapped to a List<E>
     * from a SQL result set.
     */
    public List<TicketEntity> getAllTickets() {
        return jdbcTemplate.query(GET_ALL_TICKETS, new TicketMapper());
    }

    /**
     * Query to get all the tickets by month.
     * @param month the specified month
     * @return a {@link List} of {@link TicketEntity} objects.
     */
    public List<TicketEntity> getAllTicketsByMonth(int month) {
        return jdbcTemplate.query(GET_ALL_TICKETS_BY_MONTH, new Object[]{month}, new TicketMapper());
    }

    /**
     * Query to get all the tickets by month and day
     * @param month the specified month.
     * @param day the specified day.
     * @return a {@link List} of {@link TicketEntity} objects.
     */
    public List<TicketEntity> getAllTicketsByDay(int month, int day) {
        return jdbcTemplate.query(GET_ALL_TICKETS_BY_DAY, new Object[]{month, day}, new TicketMapper());
    }

    /**
     * Used to persist a TicketEntity to a database.
     * @param ticket a TicketEntity to be mapped to sql and inserted.
     */
    public void createTicket(TicketEntity ticket) {
        jdbcTemplate.update(CREATE_TICKET, new Object[] {ticket.getTicketDate(), ticket.getEnterTime(), ticket.getExitTime()});
    }

    /**
     * Used to update a ticket was it is closed. Update statement
     * is made to a database.
     * @param ticket a TicketEntity to be mapped to sql and updated.
     */
    public void updateTicket(TicketEntity ticket) {
        jdbcTemplate.update(UPDATE_TICKET, new Object[] {ticket.getExitTime(), ticket.isTicketLost(), ticket.getAmountDue(), ticket.getId()});
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
