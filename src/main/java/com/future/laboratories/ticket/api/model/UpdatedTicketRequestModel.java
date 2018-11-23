/* COPYRIGHT © 2018 GARETH BOCK AND/OR ITS AFFILIATES. ALL RIGHTS RESERVED. */

package com.future.laboratories.ticket.api.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * This class acts as a request model for closing a ticket.
 */
public class UpdatedTicketRequestModel {

    private LocalDate ticketDate;
    private LocalTime exitTime;
    private boolean ticketLost;

    public UpdatedTicketRequestModel() {
    }

    public LocalDate getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(LocalDate ticketDate) {
        this.ticketDate = ticketDate;
    }

    public LocalTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalTime exitTime) {
        this.exitTime = exitTime;
    }

    public boolean isTicketLost() {
        return ticketLost;
    }

    public void setTicketLost(boolean ticketLost) {
        this.ticketLost = ticketLost;
    }

    @Override
    public String toString() {
        return "UpdatedTicketRequestModel{" +
                "ticketDate=" + ticketDate +
                ", exitTime=" + exitTime +
                ", ticketLost=" + ticketLost +
                '}';
    }
}
