package com.future.laboratories.shared.dao;

public final class TicketOperations {

    public static final String GET_TICKET_BY_ID = "select * from ticket where ticket_id = ?";
    public static final String GET_ALL_TICKETS = "select * from ticket";
    public static final String CREATE_TICKET = "insert into ticket (ticket_id, ticket_date, ticket_enter_time, ticket_exit_time) values (?, ?, ?, ?)";
    public static final String UPDATE_TICKET = "update ticket set ticket_exit_time = ?, is_ticket_lost = ?, amount_due = ? where id = ?";

}
