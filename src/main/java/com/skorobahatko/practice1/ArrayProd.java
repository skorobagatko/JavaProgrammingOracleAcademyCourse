package com.skorobahatko.practice1;

import java.util.Arrays;

public class ArrayProd {

    private int[] arr;

    public static int prod(int[] arr) {
        return Arrays.stream(arr).reduce((a, b) -> a * b).getAsInt();
    }

    public ArrayProd(int[] arr) {
        this.arr = arr;
    }

    public int prod() {
        return Arrays.stream(arr).reduce((a, b) -> a * b).getAsInt();
    }

}
