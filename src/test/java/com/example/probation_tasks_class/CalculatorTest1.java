package com.example.probation_tasks_class;

import com.example.probation_tasks.test_class.Calculator;
import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

public class CalculatorTest1 {

    @Test
    void shouldSumTwoNumber() {
        int a = 10;
        int b = 10;
        Assertions.assertNotEquals(3, Calculator.sum(a, b));
    }

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void failsIfExecutionTimeExceeds100Milliseconds() throws InterruptedException {
        int a = 10;
        int b = 10;
        Thread.sleep(500);
        Assertions.assertNotEquals(3, Calculator.sum(a, b));
    }

    @Test
    void shouldDifferenceTwoNumber() {
        long a = 10L;
        long b = 10L;
        Assertions.assertEquals(20, Calculator.diff(a, b));
    }

    @Test
    void shouldMultiTwoNumber() {
        double a = 10;
        double b = 10;
        Assumptions.assumeTrue(Calculator.multi(a, b) < 0);
    }

    @Test
    void shouldDivideTwoNumberAndGetZero() {
        double a = 10;
        double b = 0;
        Assertions.assertEquals(0, Calculator.division(b, a));
    }

    @Test
    void shouldDivideTwoNumberAndGetInfinity() {
        double a = 10;
        double b = 0;
        Assertions.assertEquals(0, Calculator.division(a, b));
    }

    @Test
    @Disabled
    void shouldDivideTwoNumberAndGetException() {
        int a = 10;
        int b = 0;
        Assertions.assertThrows(ArithmeticException.class,
                () -> Calculator.division(a, b));
    }
}
