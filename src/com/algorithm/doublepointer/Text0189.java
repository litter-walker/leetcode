package com.algorithm.doublepointer;

/**
 * 直接数组复制
 */
public class Text0189 {

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0 || nums.length < 2) {
            return;
        }
        int[] intK = new int[k];
        System.arraycopy(nums, nums.length - k, intK, 0, k);
        System.arraycopy(nums, 0, nums, k, nums.length - k);
        System.arraycopy(intK, 0, nums, 0, k);
    }

}
