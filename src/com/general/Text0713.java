package com.general;

/**
 * 滑动窗口
 */
public class Text0713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }
        int n = nums.length;
        int ans = 0, product = 1;
        // 左开右闭
        int l = 0, r = 0;
        while (r < n) {
            product *= nums[r];
            r++;
            ans += r - l;
            while (product >= k) {
                ans--;
                product /= nums[l];
                l++;
            }
        }
        return ans;
    }

}
