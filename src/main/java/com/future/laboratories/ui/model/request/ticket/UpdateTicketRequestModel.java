package com.future.laboratories.ui.model.request.ticket;

import java.time.LocalTime;

/**
 * This class acts as a request model for
 * when the client updates a ticket.
 */
public class UpdateTicketRequestModel {

    private LocalTime exitTime;
    private boolean isTicketLost;

    public UpdateTicketRequestModel() {
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

    @Override
    public String toString() {
        return "UpdateTicketRequestModel{" +
                "exitTime=" + exitTime +
                ", isTicketLost=" + isTicketLost +
                '}';
    }
}
