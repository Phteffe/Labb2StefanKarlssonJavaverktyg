package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
    @Test
    void callAddWithThreeStringNumbersNewLineDelimitedShouldSplitAndReturnSum() {
        assertEquals(6,stringCalc.add("1\n2,3"));
    }
    @ParameterizedTest
    @CsvSource({"'//;\n1;2', 3", "'//€\n1€2\n3,4€5', 15"})
    void callAddMethodWithStringAndNewDelimiterReturnExpectedIntValue(String numbers, int expected){

        assertThat(stringCalc.add(numbers)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"'1,2,-1', 'negatives not allowed: [-1]'", "'-1,-2,-3,-4,-5', 'negatives not allowed: [-1, -2, -3, -4, -5]'"})
    void callAddMethodWithNegativeNumberShouldThrowAnException(String numbers, String expected) {

        assertThatThrownBy(() -> stringCalc.add(numbers)).isInstanceOf(IllegalArgumentException.class).hasMessage(expected);
    }

    @ParameterizedTest
    @CsvSource({"'1,1001', '1'", "'3,2000','3'"})
    void numbersBiggerThanOneThousandIsIgnored(String numbers, int expected) {
       assertThat(stringCalc.add(numbers)).isEqualTo(expected);

    }
    @ParameterizedTest
    @CsvSource({"'//[***]\n1***2***3', 6" , "'//[#####]\n1#####1#####1', 3"})
    void anyLengthDelimiterShouldReturnExpectedValue(String numbers, int expected){
        assertThat(stringCalc.add(numbers)).isEqualTo(expected);
    }
    @ParameterizedTest
    @CsvSource({"'//[%][&]\n1%2&3', 6", "'//[@][£]\n2@2£2',6"})
    void multipleDelimitersShouldReturnSum(String numbers, int expected){
        assertThat(stringCalc.add(numbers)).isEqualTo(expected);
    }

}
