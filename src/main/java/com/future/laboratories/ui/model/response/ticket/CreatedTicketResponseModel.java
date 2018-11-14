package com.future.laboratories.ui.model.response.ticket;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * This class acts as a response model for
 * when the client creates a ticket.
 */
public class CreatedTicketResponseModel {

    private int ticketId;
    private LocalDate ticketDate;
    private LocalTime enterTime;

    public CreatedTicketResponseModel() {
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public LocalDate getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(LocalDate ticketDate) {
        this.ticketDate = ticketDate;
    }

    public LocalTime getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(LocalTime enterTime) {
        this.enterTime = enterTime;
    }

    @Override
    public String toString() {
        return "CreatedTicketResponseModel{" +
                "ticketId=" + ticketId +
                ", ticketDate=" + ticketDate +
                ", enterTime=" + enterTime +
                '}';
    }
}
