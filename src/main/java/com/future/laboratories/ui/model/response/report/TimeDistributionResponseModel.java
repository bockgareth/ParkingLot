package com.future.laboratories.ui.model.response.report;

import java.util.HashMap;
import java.util.Map;

public class TimeDistributionResponseModel {

    private int month;
    private int day;
    private Map<String, Integer> time = new HashMap<>();

    public TimeDistributionResponseModel() {
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

    public Map<String, Integer> getTime() {
        return time;
    }

    public void setTime(Map<String, Integer> time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "TimeDistributionResponseModel{" +
                "month=" + month +
                ", day=" + day +
                ", timeMap=" + time +
                '}';
    }
}
