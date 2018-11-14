package com.future.laboratories.ui.model.response.report;

public class PaymentModeResponseModel {
    private int month;
    private int day;
    private int mode;

    public PaymentModeResponseModel() {
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

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "PaymentModeResponseModel{" +
                "month=" + month +
                ", day=" + day +
                ", mode=" + mode +
                '}';
    }
}
