package com.day02;

import java.util.Arrays;

public class test2 {

    public static void rotate(int[] nums, int k) {

        k %= nums.length;
        if (k == 0 || nums.length < 2) {
            return;
        }

        int[] intK = new int[k];
        System.arraycopy(nums, nums.length - k, intK, 0, k);
        System.arraycopy(nums, 0, nums, k, nums.length - k);
        System.arraycopy(intK, 0, nums, 0, k);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        System.out.println("nums = " + Arrays.toString(nums));
        rotate(nums, k);
        System.out.println("nums = " + Arrays.toString(nums));

    }
}
