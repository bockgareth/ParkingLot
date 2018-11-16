package com.future.laboratories.shared.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * This class acts as a time distribution data transfer
 * object. Has no communication with data layer.
 */
public class TimeDistributionDto {

    private int month;
    private int day;
    private Map<String, Integer> timeMap = new HashMap<>();
    private int nine = 0;
    private int nineThirty = 0;
    private int ten = 0;
    private int tenThirty = 0;
    private int eleven = 0;
    private int elevenThirty = 0;
    private int twelve = 0;
    private int twelveThirty = 0;
    private int thirteen = 0;
    private int thirteenThirty = 0;
    private int fourteen = 0;
    private int fourteenThirty = 0;
    private int fifteen = 0;

    public TimeDistributionDto() {
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

    public Map<String, Integer> getTimeMap() {
        return timeMap;
    }

    public void setTimeMap(Map<String, Integer> timeMap) {
        this.timeMap = timeMap;
    }

    public int getNine() {
        return nine;
    }

    public void setNine(int nine) {
        this.nine = nine;
    }

    public int getNineThirty() {
        return nineThirty;
    }

    public void setNineThirty(int nineThirty) {
        this.nineThirty = nineThirty;
    }

    public int getTen() {
        return ten;
    }

    public void setTen(int ten) {
        this.ten = ten;
    }

    public int getTenThirty() {
        return tenThirty;
    }

    public void setTenThirty(int tenThirty) {
        this.tenThirty = tenThirty;
    }

    public int getEleven() {
        return eleven;
    }

    public void setEleven(int eleven) {
        this.eleven = eleven;
    }

    public int getElevenThirty() {
        return elevenThirty;
    }

    public void setElevenThirty(int elevenThirty) {
        this.elevenThirty = elevenThirty;
    }

    public int getTwelve() {
        return twelve;
    }

    public void setTwelve(int twelve) {
        this.twelve = twelve;
    }

    public int getTwelveThirty() {
        return twelveThirty;
    }

    public void setTwelveThirty(int twelveThirty) {
        this.twelveThirty = twelveThirty;
    }

    public int getThirteen() {
        return thirteen;
    }

    public void setThirteen(int thirteen) {
        this.thirteen = thirteen;
    }

    public int getThirteenThirty() {
        return thirteenThirty;
    }

    public void setThirteenThirty(int thirteenThirty) {
        this.thirteenThirty = thirteenThirty;
    }

    public int getFourteen() {
        return fourteen;
    }

    public void setFourteen(int fourteen) {
        this.fourteen = fourteen;
    }

    public int getFourteenThirty() {
        return fourteenThirty;
    }

    public void setFourteenThirty(int fourteenThirty) {
        this.fourteenThirty = fourteenThirty;
    }

    public int getFifteen() {
        return fifteen;
    }

    public void setFifteen(int fifteen) {
        this.fifteen = fifteen;
    }

    @Override
    public String toString() {
        return "TimeDistributionDto{" +
                "month=" + month +
                ", day=" + day +
                ", nine=" + nine +
                ", nineThirty=" + nineThirty +
                ", ten=" + ten +
                ", tenThirty=" + tenThirty +
                ", eleven=" + eleven +
                ", elevenThirty=" + elevenThirty +
                ", twelve=" + twelve +
                ", twelveThirty=" + twelveThirty +
                ", thirteen=" + thirteen +
                ", thirteenThirty=" + thirteenThirty +
                ", fourteen=" + fourteen +
                ", fourteenThirty=" + fourteenThirty +
                ", fifteen=" + fifteen +
                '}';
    }
}
