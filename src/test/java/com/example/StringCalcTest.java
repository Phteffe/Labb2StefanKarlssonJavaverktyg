package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalcTest {
    @Test
    void callAddWithEmptyStringShouldReturn0() {
        assertEquals(0,StringCalc.add(""));
    }

    @Test
    void callAddWithIntegerStringShouldReturnEqualInteger() {
        assertEquals(1,StringCalc.add("1"));
    }

    @Test
    void callAddWithTwoStringNumbersShouldSplitAndReturnSum() {
        assertEquals(2,StringCalc.add("1,1"));
    }
    @Test
    void callAddWithThreeStringNumbersShouldSplitAndReturnSum() {
        assertEquals(6,StringCalc.add("1,2,3"));
    }
    @Test
    void callAddWithEightStringNumbersShouldSplitAndReturnSum() {
        assertEquals(36,StringCalc.add("1,2,3,4,5,6,7,8"));
    }

}
