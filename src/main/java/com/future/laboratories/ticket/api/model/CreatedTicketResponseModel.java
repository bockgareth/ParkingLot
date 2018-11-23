/* COPYRIGHT © 2018 GARETH BOCK AND/OR ITS AFFILIATES. ALL RIGHTS RESERVED. */

package com.future.laboratories.ticket.api.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * This class acts as a response model for
 * when the client creates a ticket.
 */
public class CreatedTicketResponseModel {

    private LocalDate ticketDate;
    private LocalTime enterTime;

    public CreatedTicketResponseModel() {
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
                ", ticketDate=" + ticketDate +
                ", enterTime=" + enterTime +
                '}';
    }
}
