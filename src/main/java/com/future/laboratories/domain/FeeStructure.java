package com.future.laboratories.domain;

import java.util.List;

public class FeeStructure {

    private List<Fee> boundaries;
    private int lostFee;

    public FeeStructure(int lostFee, List<Fee> fees) {
        this.lostFee = lostFee;
        this.boundaries = fees;
    }

    public int calculateFee(long m) {
        int loopSize = this.boundaries.size() - 1;
        for (int i = 0; i < loopSize; i++) {
            if (boundaries.get(i).getBegin() >= m && boundaries.get(i).getEnd() < m) return boundaries.get(i).getAmountDue();
        }
        return boundaries.get(loopSize).getAmountDue();
    }

    public List<Fee> getBoundaries() {
        return boundaries;
    }

    public void setBoundaries(List<Fee> boundaries) {
        this.boundaries = boundaries;
    }

    public int getLostFee() {
        return lostFee;
    }

    public void setLostFee(int lostFee) {
        this.lostFee = lostFee;
    }
}
