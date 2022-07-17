package com.general.text0565;

/**
 * 图 + 标记
 */
public class Solution {
    public int arrayNesting(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int index = i;
            int count = 0;
            while (nums[index] != -1) {
                int next = nums[index];
                nums[index] = -1;
                index = next;
                count++;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
