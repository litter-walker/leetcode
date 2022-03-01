package com.algorithm.doublepointer;

/**
 * 双指针
 *
 */
public class Text0283 {
    public void moveZeroes(int[] nums) {
        int l = 0, r =0;
        while (r < nums.length) {
            if (nums[r] != 0) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
            }
            r++;
        }
    }
}
