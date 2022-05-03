package com.general;

/**
 * 脑筋急转弯-模拟
 */
public class Text0908 {
    public int smallestRangeI(int[] nums, int k) {
        int maxNum = nums[0];
        int minNum = nums[0];
        for (int num : nums) {
            if (num > maxNum) {
                maxNum = num;
            } else if (num < minNum) {
                minNum = num;
            }
        }
        return (maxNum - minNum) > (2 * k) ? (maxNum - minNum - 2 * k) : 0;
    }
}
