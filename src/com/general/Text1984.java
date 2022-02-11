package com.general;

import java.util.Arrays;

/**
 * 排序+滑动窗口
 */
public class Text1984 {

    public static int minimumDifference(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = k - 1; i < nums.length; i++) {
            ans = Math.min(nums[i] - nums[i - k + 1], ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {9,4,1,7};
        int k = 2;
        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("k = " + k);
        System.out.println("minimumDifference(nums, k) = " + minimumDifference(nums, k));
    }

}
