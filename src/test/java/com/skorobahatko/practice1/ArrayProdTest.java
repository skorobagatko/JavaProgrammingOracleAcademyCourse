package com.skorobahatko.practice1;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayProdTest {

    private static int[] arr;

    @BeforeClass
    public static void setUp() throws Exception {
        arr = new int[]{1,2,3,4};
    }

    @Test
    public void testProdStaticPositive() {
        int expected = 24;
        int actual = ArrayProd.prod(arr);
        assertEquals(expected, actual);
    }

    @Test
    public void testProdIntancePositive() {
        ArrayProd arrayProd = new ArrayProd(arr);
        int expected = 24;
        int actual = arrayProd.prod();
        assertEquals(expected, actual);
    }
}