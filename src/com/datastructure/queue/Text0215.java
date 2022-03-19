package com.datastructure.queue;

/**
 * 快速排序
 */
public class Text0215 {

    public int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        int idx;
        do {
            idx = selectionSort(nums, l, r);
            if (idx < nums.length - k) {
                l = idx + 1;
            } else {
                r = idx - 1;
            }
        } while (idx != nums.length - k);
        return nums[idx];
    }

    private int selectionSort(int[] nums, int l, int r) {
        int target = l;
        while (l < r) {
            while (nums[l] <= nums[target] && l < nums.length - 1) {
                l++;
            }
            while (nums[r] > nums[target] && r > 0) {
                r--;
            }
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = nums[target];
        nums[target] = temp;
        return r;
    }
}
