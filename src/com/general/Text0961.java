package com.general;

/**
 * 技巧题：
 *  由于题目 nums.length = 2 * n, 而且数字有 n + 1种，
 *  那么，重复的哪一个数字的 n 个位置，两两相差应该不超过 2
 *
 *  特殊情况下，n == 2， 可能出现 [x, 1, 2, x] 这样的用例；
 *      这样的解决方案可以，将nums看作为一个环状数组
 */
public class Text0961 {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;
        // 当 n == 2 时，避免出现 [9,5,6,9] 这样的特殊用例
        if (nums[0] == nums[n - 1]) {
            return nums[0];
        }
        for (int i = 2; i < n; i++) {
            if (nums[i] == nums[i - 1] || nums[i] == nums[i - 2]) {
                return nums[i];
            }
        }
        return 0;
    }
}
