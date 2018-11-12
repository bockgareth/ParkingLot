package com.future.laboratories.shared.dao.impl;

import com.future.laboratories.entity.TicketEntity;
import com.future.laboratories.shared.dao.TicketDao;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketDaoImpl extends JdbcDaoSupport implements TicketDao {

    public TicketEntity getTicketById(int id) {
        String sql = "select * from ticket where ticket_id = ?";
        return this.getJdbcTemplate().queryForObject(sql, new Object[] {id}, new TicketMapper());
    }

    public int getTicketCount() {
        String sql = "select count(*) from ticket";
        return this.getJdbcTemplate().queryForObject(sql, Integer.class);
    }

    private static final class TicketMapper implements RowMapper<TicketEntity> {

        @Override
        public TicketEntity mapRow(ResultSet resultSet, int i) throws SQLException {
            TicketEntity ticket = new TicketEntity();
            ticket.setId(resultSet.getInt("id"));
            ticket.setTicketId(resultSet.getInt("ticket_id"));
            ticket.setTicketDate(resultSet.getDate("ticket_date").toLocalDate());
            ticket.setEnterTime(resultSet.getTime("ticket_enter_time").toLocalTime());
            ticket.setExitTime(resultSet.getTime("ticket_exit_time").toLocalTime());
            ticket.setTicketLost(resultSet.getBoolean("is_ticket_lost"));
            ticket.setAmountDue(resultSet.getInt("amount_due"));
            return ticket;
        }
    }
}
