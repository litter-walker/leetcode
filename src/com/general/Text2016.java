package com.general;

/**
 * 简单dp：(可状态压缩)
 *  使用dp[i]表示前i个元素中的最大差值；
 *  另外使用一个curMin表示当前的最小值；
 *
 */
public class Text2016 {

    public int maximumDifference(int[] nums) {
        int dp = -1;
        int curMin = nums[0];
        for (int num : nums) {
            if (curMin < num) {
                dp = Math.max(dp, num - curMin);
            } else {
                curMin = num;
            }
        }
        return dp;
    }

    public static void main(String[] args) {

    }
}
