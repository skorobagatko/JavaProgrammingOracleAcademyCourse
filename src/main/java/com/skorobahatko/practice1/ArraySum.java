package com.skorobahatko.practice1;

import java.util.Arrays;

public class ArraySum {

    private int[] arr;

    public static int sum(int[] arr) {
        return Arrays.stream(arr).sum();
    }

    public ArraySum(int[] arr) {
        this.arr = arr;
    }

    public int sum() {
        return Arrays.stream(arr).sum();
    }

}
