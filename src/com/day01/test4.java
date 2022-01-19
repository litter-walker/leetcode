package com.day01;

/**
 * 二分查找
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target，写一个函数搜索nums中的 target，
 * 如果目标值存在返回下标，否则返回 -1。
 */
public class test4 {

    public static int search(int[] nums, int target) {

        int l = 0, r = nums.length - 1;
        do {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        } while(l <= r);
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {-1,0,3,5,9,12};
        System.out.println(search(a, 9));

    }
}
