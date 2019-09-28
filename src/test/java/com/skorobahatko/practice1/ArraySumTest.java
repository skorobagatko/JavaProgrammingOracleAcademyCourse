package com.skorobahatko.practice1;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ArraySumTest {

    private static int[] arr;

    @BeforeClass
    public static void setUp() throws Exception {
        arr = new int[]{1,2,3,4};
    }

    @Test
    public void testSumStaticPositive() {
        int expected = 10;
        int actual = ArraySum.sum(arr);
        assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void testSumStaticNull() {
        int expected = 10;
        int actual = ArraySum.sum(null);
        fail();
    }

    @Test
    public void testSumInstance() {
        ArraySum arraySum = new ArraySum(arr);
        int expected = 10;
        int actual = arraySum.sum();
        assertEquals(expected, actual);
    }


}