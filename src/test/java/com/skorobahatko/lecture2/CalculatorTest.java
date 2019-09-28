package com.skorobahatko.lecture2;

import org.junit.*;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void init() throws Exception {
        calculator = new Calculator();
    }

    @After
    public void destroy() throws Exception {
        calculator = null;
    }

    @Test
    public void sum() {
        int a = 2;
        int b = 3;
        int expected = 5;
        int actual = calculator.sum(a, b);
        assertEquals(expected, actual);
    }

    @Test
    public void divide() {
        int a = 10;
        int b = 2;
        int expected = 5;
        int actual = calculator.divide(a, b);
        assertEquals(expected, actual);
    }

    @Test(expected = ArithmeticException.class)
    public void divideByZero() {
        calculator.divide(1, 0);
    }

}