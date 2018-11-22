package com.future.laboratories.report.api.model;

public class SpaceRanOutResponseModel {

    private int month;
    private int day;
    private int noSpaceCount;

    public SpaceRanOutResponseModel() {
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

    public int getNoSpaceCount() {
        return noSpaceCount;
    }

    public void setNoSpaceCount(int noSpaceCount) {
        this.noSpaceCount = noSpaceCount;
    }

    @Override
    public String toString() {
        return "SpaceRanOutResponseModel{" +
                "month=" + month +
                ", day=" + day +
                ", noSpaceCount=" + noSpaceCount +
                '}';
    }
}
