package com.general;

/**
 * 双指针
 */
public class Text0905 {
    public int[] sortArrayByParity(int[] nums) {
        int len = nums.length;
        int l = -1, r = len;
        while (l < r) {
            do {
                l++;
            } while (l < len - 1 && nums[l] % 2 == 0);
            do {
                r--;
            } while (r > 0 && nums[r] % 2 == 1);
            swap(nums, l, r);
        }
        swap(nums, l, r);
        return nums;
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
