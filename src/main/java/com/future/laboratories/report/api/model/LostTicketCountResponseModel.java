/* COPYRIGHT © 2018 GARETH BOCK AND/OR ITS AFFILIATES. ALL RIGHTS RESERVED. */

package com.future.laboratories.report.api.model;

/**
 * This class acts as a response model for
 * when the client requests a report on the number
 * of tickets lost during the day.
 */
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
