package com.future.laboratories.ui.model.response.report;

public class LostTicketCountResponseModel {
    private int month;
    private int day;
    private int lost;

    public LostTicketCountResponseModel() {
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
        return "LostTicketCountResponseModel{" +
                "month=" + month +
                ", day=" + day +
                ", lost=" + lost +
                '}';
    }
}