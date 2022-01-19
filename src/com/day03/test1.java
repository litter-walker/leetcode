package com.day03;

import java.util.Arrays;

public class test1 {


    public static void moveZeroes(int[] nums) {

        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                zeroCount++;
                continue;
            } else {
                nums[i - zeroCount] = nums[i];
            }
        }

        for (int count = zeroCount; count > 0; count--) {
            nums[nums.length - count] = 0;
        }
    }

    public static void main(String[] args) {

        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);

        System.out.println("nums = " + Arrays.toString(nums));
    }

}
