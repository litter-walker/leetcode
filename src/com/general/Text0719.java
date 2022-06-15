package com.general;

import java.util.Arrays;

/**
 * 二分 + 双指针
 */
public class Text0719 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums[nums.length - 1] - nums[0];
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (countOfLessThanK(mid, nums) >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    public int countOfLessThanK(int k, int[] nums) {
        int count = 0;
        for (int i = 0, j = 0; j < nums.length; j++) {
            while (nums[j] - nums[i] > k) {
                i++;
            }
            count += j - i;
        }
        return count;
    }
}
