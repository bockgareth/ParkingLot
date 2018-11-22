package com.future.laboratories.domain.impl;

import com.future.laboratories.domain.Fee;
import com.future.laboratories.domain.FeeStructure;

import java.util.List;

/**
 * This class acts as fee structure that models the structure of {@link Fee}.
 */
public class FeeStructureImpl implements FeeStructure {

    private List<Fee> boundaries;
    private int lostFee;

    public FeeStructureImpl(int lostFee, List<Fee> fees) {
        this.lostFee = lostFee;
        this.boundaries = fees;
    }

    /**
     * Used to calculate a fee based on minutes.
     * @param m the minute difference that comes from two times.
     * @return the amount due.
     */
    public int calculateFee(long m) {
        int loopSize = this.boundaries.size() - 1;
        for (int i = 0; i < loopSize; i++) {
            if (m >= boundaries.get(i).getBegin() && m < boundaries.get(i).getEnd() ) {
                return boundaries.get(i).getAmountDue();
            }
        }
        if (m < 0) {
            return lostFee;
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
