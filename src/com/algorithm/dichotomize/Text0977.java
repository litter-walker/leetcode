package com.algorithm.dichotomize;

import java.util.Arrays;

/**
 * 双指针
 */
public class Text0977 {


    public static int[] sortedSquares(int[] nums) {

        int l = 0, r = nums.length - 1;
        int[] ans = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--) {
            if(Math.abs(nums[l]) > Math.abs(nums[r])) {
                ans[i] = nums[l] * nums[l];
                l++;
            } else {
                ans[i] = nums[r] * nums[r];
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-4,-1,0,3,10};

        System.out.println(Arrays.toString(sortedSquares(nums)));

    }


}
