package com.general;

import java.util.Arrays;

public class Text0747 {

    public static int dominantIndex(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }

        int maxNumSub = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[maxNumSub]) {
                maxNumSub = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(maxNumSub != i && nums[maxNumSub] < nums[i] * 2) {
                return -1;
            }
        }
        return maxNumSub;
    }

    public static void main(String[] args) {

        int[] nums = {1,0};
        System.out.println("nums = " + Arrays.toString(nums));

        System.out.println("dominantIndex(nums) = " + dominantIndex(nums));
    }
}
