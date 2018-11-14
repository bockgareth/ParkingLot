package com.future.laboratories.ui.model.response.report;

public class RevenueMonthResponseModel {
    private int month;
    private int revenue;

    public RevenueMonthResponseModel() {
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    @Override
    public String toString() {
        return "RevenueMonthResponseModel{" +
                "month=" + month +
                ", revenue=" + revenue +
                '}';
    }
}
