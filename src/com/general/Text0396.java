package com.general;

/**
 * 迭代-数学
 */
public class Text0396 {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        // 求出 sum 和 f0
        int sum = 0, f = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            f += nums[i] * i;
        }
        int ans = f;
        for (int k = 1; k < n; k++) {
            f += sum - nums[n - k] * n;
            ans = Math.max(f, ans);
        }
        return ans;
    }
}
