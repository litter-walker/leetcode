package com.day01;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class test5 {

    public static int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length;
        do {
            int mid = (l + r) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        } while(l <= r);
        return l;
    }


    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 0;
        searchInsert(nums, target);
    }


}
