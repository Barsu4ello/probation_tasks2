package com.example.probation_tasks_class;

import com.example.probation_tasks.test_class.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import static org.junit.jupiter.api.RepeatedTest.SHORT_DISPLAY_NAME;

//https://www.baeldung.com/parameterized-tests-junit-5
//https://habr.com/ru/post/591007/

public class CalculatorTest2 {

    @Test
    @EnabledOnOs(value = {OS.LINUX, OS.MAC},
            disabledReason = "I want use this test only on LINUX and MAC")
    void shouldSumTwoNumberOnlyOnLinuxAndMac() {
        int a = 10;
        int b = 10;
        Assertions.assertNotEquals(3, Calculator.sum(a, b));
    }

    @Test
    @DisabledOnOs(value = OS.WINDOWS, disabledReason = "I don't want use this test on Windows")
    void shouldNotSumTwoNumberOnWindows() {
        int a = 10;
        int b = 10;
        Assertions.assertNotEquals(3, Calculator.sum(a, b));
    }

    @RepeatedTest(value = 100, name = SHORT_DISPLAY_NAME)
    @DisplayName("Repeat sum two numbers 100 times")
    void shouldSumTwoNumber100Times() {
        int a = 10;
        int b = new Random().nextInt(100);
        Assertions.assertNotEquals(100, Calculator.sum(a, b));
    }


    @ParameterizedTest(name = "Test: {index} - Value: {arguments}")
    @ValueSource(doubles = {1, 2, 3, 4, 5})
    @DisplayName("Repeat sum two numbers with different value")
    void shouldSumTwoNumberWithDifferentValue(double b) {
        int a = 10;
        Assertions.assertEquals(15, Calculator.sum(a, b));
    }

    @ParameterizedTest(name = "Test: {index} - Value: {arguments}")
    @MethodSource("createPairNumber")
    @DisplayName("Repeat sum two numbers with different value")
    void shouldSumTwoNumberWithDifferentValue2(double a, double b) {
        Assertions.assertEquals(15, Calculator.sum(a, b));
    }

    private static Collection createPairNumber(){
        return Arrays.asList(new Object[][] {
                {5,5},
                {5,10},
                {5,15},
        });
    }
}
