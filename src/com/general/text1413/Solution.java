package com.general.text1413;

/*
    前缀和
 */
public class Solution {
    public int minStartValue(int[] nums) {
        int min = 0;
        int preSum = 0;
        for (int num : nums) {
            preSum += num;
            min = Math.min(min, preSum);
        }
        return 1 - min;
    }
}
