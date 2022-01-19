package com.general;

import java.util.Arrays;

public class Text0334 {

    public static boolean increasingTriplet(int[] nums) {
        int small, mid;
        small = mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if(num <= small) {
                small = num;
            } else if (num <= mid) {
                mid = num;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,3,2,3};
        System.out.println("nums = " + Arrays.toString(nums));

        System.out.println("increasingTriplet(nums) = " + increasingTriplet(nums));

    }

}