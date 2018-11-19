package com.future.laboratories.domain;

public class Fee {
    private int begin;
    private int end = Integer.MAX_VALUE;
    private int amountDue;

    public Fee(int begin, int end, int amountDue) {
        this.begin = begin;
        this.end = end;
        this.amountDue = amountDue;
    }

    public Fee(int begin, int amountDue) {
        this.begin = begin;
        this.amountDue = amountDue;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(int amountDue) {
        this.amountDue = amountDue;
    }

    @Override
    public String toString() {
        return "Fee{" +
                "begin=" + begin +
                ", end=" + end +
                ", amountDue=" + amountDue +
                '}';
    }
}
