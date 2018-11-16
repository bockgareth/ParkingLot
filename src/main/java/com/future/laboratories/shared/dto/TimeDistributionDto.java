package com.future.laboratories.shared.dto;

/**
 * This class acts as a time distribution data transfer
 * object. Has no communication with data layer.
 */
public class TimeDistributionDto {

    private int month;
    private int day;
    private int Nine = 0;
    private int NineThirty = 0;
    private int Ten = 0;
    private int TenThirty = 0;
    private int Eleven = 0;
    private int ElevenThirty = 0;
    private int Twelve = 0;
    private int TwelveThirty = 0;
    private int Thirteen = 0;
    private int ThirteenThirty = 0;
    private int Fourteen = 0;
    private int FourteenThirty = 0;
    private int Fifteen = 0;
    private int FifteenThirty = 0;

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

    public int getNine() {
        return Nine;
    }

    public void setNine(int nine) {
        Nine = nine;
    }

    public int getNineThirty() {
        return NineThirty;
    }

    public void setNineThirty(int nineThirty) {
        NineThirty = nineThirty;
    }

    public int getTen() {
        return Ten;
    }

    public void setTen(int ten) {
        Ten = ten;
    }

    public int getTenThirty() {
        return TenThirty;
    }

    public void setTenThirty(int tenThirty) {
        TenThirty = tenThirty;
    }

    public int getEleven() {
        return Eleven;
    }

    public void setEleven(int eleven) {
        Eleven = eleven;
    }

    public int getElevenThirty() {
        return ElevenThirty;
    }

    public void setElevenThirty(int elevenThirty) {
        ElevenThirty = elevenThirty;
    }

    public int getTwelve() {
        return Twelve;
    }

    public void setTwelve(int twelve) {
        Twelve = twelve;
    }

    public int getTwelveThirty() {
        return TwelveThirty;
    }

    public void setTwelveThirty(int twelveThirty) {
        TwelveThirty = twelveThirty;
    }

    public int getThirteen() {
        return Thirteen;
    }

    public void setThirteen(int thirteen) {
        Thirteen = thirteen;
    }

    public int getThirteenThirty() {
        return ThirteenThirty;
    }

    public void setThirteenThirty(int thirteenThirty) {
        ThirteenThirty = thirteenThirty;
    }

    public int getFourteen() {
        return Fourteen;
    }

    public void setFourteen(int fourteen) {
        Fourteen = fourteen;
    }

    public int getFourteenThirty() {
        return FourteenThirty;
    }

    public void setFourteenThirty(int fourteenThirty) {
        FourteenThirty = fourteenThirty;
    }

    public int getFifteen() {
        return Fifteen;
    }

    public void setFifteen(int fifteen) {
        Fifteen = fifteen;
    }

    public int getFifteenThirty() {
        return FifteenThirty;
    }

    public void setFifteenThirty(int fifteenThirty) {
        FifteenThirty = fifteenThirty;
    }

    @Override
    public String toString() {
        return "TimeDistributionResponseModel{" +
                "month=" + month +
                ", day=" + day +
                ", Nine=" + Nine +
                ", NineThirty=" + NineThirty +
                ", Ten=" + Ten +
                ", TenThirty=" + TenThirty +
                ", Eleven=" + Eleven +
                ", ElevenThirty=" + ElevenThirty +
                ", Twelve=" + Twelve +
                ", TwelveThirty=" + TwelveThirty +
                ", Thirteen=" + Thirteen +
                ", ThirteenThirty=" + ThirteenThirty +
                ", Fourteen=" + Fourteen +
                ", FourteenThirty=" + FourteenThirty +
                ", Fifteen=" + Fifteen +
                ", FifteenThirty=" + FifteenThirty +
                '}';
    }
}
