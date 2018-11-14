package com.future.laboratories.ui.model.response.report;

public class RevenueMonthDayResponseModel {
    private int month;
    private int day;
    private int revenue;

    public RevenueMonthDayResponseModel() {
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

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    @Override
    public String toString() {
        return "RevenueMonthDayResponseModel{" +
                "month=" + month +
                ", day=" + day +
                ", revenue=" + revenue +
                '}';
    }
}
