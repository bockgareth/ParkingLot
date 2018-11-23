/* COPYRIGHT © 2018 GARETH BOCK AND/OR ITS AFFILIATES. ALL RIGHTS RESERVED. */

package com.future.laboratories.domain.impl;

import com.future.laboratories.domain.Fee;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FeeStructureImplTest {

    private List<Fee> feeList;

    private FeeStructureImpl fees;

    @Before
    public void setUp() {
        feeList = new ArrayList<>();
        feeList.add(new Fee(0, 29, 10));
        feeList.add(new Fee(30, 59, 20));
        feeList.add(new Fee(60, 119, 30));
        feeList.add(new Fee(120, 239, 50));
        feeList.add(new Fee(240, 100));

        fees = new FeeStructureImpl(150, feeList);
    }

    @Test
    public void calculateFee() {
        assertEquals(10, fees.calculateFee(20));
        assertEquals(30, fees.calculateFee(65));
        assertEquals(100, fees.calculateFee(250));
    }
}