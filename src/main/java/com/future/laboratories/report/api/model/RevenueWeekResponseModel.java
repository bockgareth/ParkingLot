package com.future.laboratories.report.api.model;

/**
 * This class acts as a response model for
 * when the client requests a report on the revenue
 * generated for the week of the year.
 */
public class RevenueWeekResponseModel {

    private int week;
    private int revenue;

    public RevenueWeekResponseModel() {
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    @Override
    public String toString() {
        return "RevenueWeekResponseModel{" +
                "week=" + week +
                ", revenue=" + revenue +
                '}';
    }
}
