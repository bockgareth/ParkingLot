/* COPYRIGHT © 2018 GARETH BOCK AND/OR ITS AFFILIATES. ALL RIGHTS RESERVED. */

package com.future.laboratories.ticket.dto;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * This class acts as a Ticket data transfer object. Has
 * no communication with data layer.
 */
public class TicketDto {

    private int id;
    private LocalDate ticketDate;
    private LocalTime enterTime;
    private LocalTime exitTime;
    private boolean isTicketLost;
    private int amountDue;

    public TicketDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(int amountDue) {
        this.amountDue = amountDue;
    }

    public boolean isTicketLost() {
        return isTicketLost;
    }

    public void setTicketLost(boolean ticketLost) {
        isTicketLost = ticketLost;
    }

    @Override
    public String toString() {
        return "TicketEntity{" +
                "id=" + id +
                ", ticketDate=" + ticketDate +
                ", enterTime=" + enterTime +
                ", exitTime=" + exitTime +
                ", isTicketLost=" + isTicketLost +
                ", amountDue=" + amountDue +
                '}';
    }
}
