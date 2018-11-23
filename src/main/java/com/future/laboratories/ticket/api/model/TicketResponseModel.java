/* COPYRIGHT © 2018 GARETH BOCK AND/OR ITS AFFILIATES. ALL RIGHTS RESERVED. */

package com.future.laboratories.ticket.api.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * This class acts as a response model for tickets.
 */
public class TicketResponseModel {

    private int id;
    private LocalDate ticketDate;
    private LocalTime enterTime;
    private LocalTime exitTime;
    private boolean isTicketLost;
    private int amountDue;

    public TicketResponseModel() {
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
        return "TicketResponseModel{" +
                "id=" + id +
                ", ticketDate=" + ticketDate +
                ", enterTime=" + enterTime +
                ", exitTime=" + exitTime +
                ", isTicketLost=" + isTicketLost +
                ", amountDue=" + amountDue +
                '}';
    }
}
