package com.datastructure;

import java.util.Arrays;

/**
 *
 */
public class Text0075 {

    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        for (int i = 0; i <= r; i++) {
            int temp = nums[i];
            switch (temp) {
                case 0:
                    nums[i] = nums[l];
                    nums[l++] = temp;
                    break;
                case 2:
                    nums[i--] = nums[r];
                    nums[r--] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        System.out.println("nums = " + Arrays.toString(nums));
        new Text0075().sortColors(nums);
        System.out.println("nums = " + Arrays.toString(nums));
    }

}
