package com.future.laboratories.ui.model.response.report;

public class TicketCountResponseModel {
    private int month;
    private int day;
    private int lost;

    public TicketCountResponseModel() {
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    @Override
    public String toString() {
        return "TicketCountResponseModel{" +
                "month=" + month +
                ", day=" + day +
                ", lost=" + lost +
                '}';
    }
}
