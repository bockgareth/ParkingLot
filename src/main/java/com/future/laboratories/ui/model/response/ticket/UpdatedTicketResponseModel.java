package com.future.laboratories.ui.model.response.ticket;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * This class acts as a response model for
 * when the client updates a ticket.
 */
public class UpdatedTicketResponseModel {

    private int ticketId;
    private LocalDate ticketDate;
    private LocalTime enterTime;
    private LocalTime exitTime;
    private boolean isTicketLost;
    private int amountDue;

    public UpdatedTicketResponseModel() {
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

    public LocalTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalTime exitTime) {
        this.exitTime = exitTime;
    }

    public boolean isTicketLost() {
        return isTicketLost;
    }

    public void setTicketLost(boolean ticketLost) {
        isTicketLost = ticketLost;
    }

    public int getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(int amountDue) {
        this.amountDue = amountDue;
    }

    @Override
    public String toString() {
        return "UpdatedTicketResponseModel{" +
                "ticketId=" + ticketId +
                ", ticketDate=" + ticketDate +
                ", enterTime=" + enterTime +
                ", exitTime=" + exitTime +
                ", isTicketLost=" + isTicketLost +
                ", amountDue=" + amountDue +
                '}';
    }
}
