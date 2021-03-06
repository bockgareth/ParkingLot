/* COPYRIGHT © 2018 GARETH BOCK AND/OR ITS AFFILIATES. ALL RIGHTS RESERVED. */

package com.future.laboratories.report.dto;

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
    private int spaceRanOut;

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

    public int getSpaceRanOut() {
        return spaceRanOut;
    }

    public void setSpaceRanOut(int spaceRanOut) {
        this.spaceRanOut = spaceRanOut;
    }

    @Override
    public String toString() {
        return "ReportDto{" +
                "month=" + month +
                ", day=" + day +
                ", revenue=" + revenue +
                ", lost=" + lost +
                ", mode=" + mode +
                ", spaceRanOut=" + spaceRanOut +
                '}';
    }
}
