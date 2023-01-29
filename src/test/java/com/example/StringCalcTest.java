package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
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






}
