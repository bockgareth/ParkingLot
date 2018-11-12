package com.future.laboratories.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class TicketEntity {

    private int id;
    private int ticketId;
    private LocalDate ticketDate;
    private LocalTime enterTime;
    private LocalTime exitTime;
    private boolean isTicketLost;

    private int amountDue;

    public TicketEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                ", ticketId=" + ticketId +
                ", ticketDate=" + ticketDate +
                ", enterTime=" + enterTime +
                ", exitTime=" + exitTime +
                ", isTicketLost=" + isTicketLost +
                ", amountDue=" + amountDue +
                '}';
    }
}
