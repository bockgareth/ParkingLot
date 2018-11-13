package com.future.laboratories.shared.dto;

/**
 * This class acts as a Report data transfer object. Has
 * no communication with data layer.
 */
public class ReportDto {

    private int month;
    private int day;
    private int revenue;
    private int lost;
    private int mode;

    public ReportDto() {
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

    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "ReportDto{" +
                "month=" + month +
                ", day=" + day +
                ", revenue=" + revenue +
                ", lost=" + lost +
                ", mode=" + mode +
                '}';
    }
}
