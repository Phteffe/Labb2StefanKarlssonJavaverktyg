package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalcTest {

    private StringCalc stringCalc;

    @BeforeEach
    public void init() {
        stringCalc = new StringCalc();
    }

    @Test
    void callAddWithEmptyStringShouldReturn0() {
        assertEquals(0,stringCalc.add(""));
    }

    @Test
    void callAddWithIntegerStringShouldReturnEqualInteger() {
        assertEquals(1,stringCalc.add("1"));
    }

    @Test
    void callAddWithTwoStringNumbersShouldSplitAndReturnSum() {
        assertEquals(2,stringCalc.add("1,1"));
    }
    @Test
    void callAddWithThreeStringNumbersShouldSplitAndReturnSum() {
        assertEquals(6,stringCalc.add("1,2,3"));
    }
    @Test
    void callAddWithEightStringNumbersShouldSplitAndReturnSum() {
        assertEquals(36,stringCalc.add("1,2,3,4,5,6,7,8"));
    }


}
