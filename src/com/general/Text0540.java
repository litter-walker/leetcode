package com.general;

import java.util.Arrays;

/**
 * 因为有序所以可以使用二分查找得方式得到；
 * <p>
 * 扩展：如果不是有序的可以使用 前缀异或的方式得到答案
 */
public class Text0540 {

    public static int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid + 1]) {
                    l = mid + 2;
                } else {
                    r = mid;
                }
            } else {
                if (nums[mid] == nums[mid - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return nums[r];
    }

    public static void main(String[] args) {
        int[] nums = {3,3,7,7,10,11,11};
        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("singleNonDuplicate(nums) = " + singleNonDuplicate(nums));
    }

}
