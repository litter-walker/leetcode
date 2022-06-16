package com.general;

import java.util.Arrays;

/**
 * 双指针
 */
public class Text0532 {

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);

        int ans = 0;
        for (int i = 0, j = 1; j < nums.length; j++) {
            // 每次有相同的 nums[j] 时，j 都取最后一个，避免重复
            if (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                continue;
            }
            while (nums[j] - nums[i] > k) {
                i++;
            }
            if (i < j && nums[j] - nums[i] == k) {
                ans++;
            }
        }
        return ans;
    }

}
