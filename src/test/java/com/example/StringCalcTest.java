package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalcTest {
    @Test
    void callAddWithEmptyStringShouldReturn0() {
        assertEquals(0,StringCalc.add(""));
    }
}
