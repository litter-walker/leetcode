package com.offer;

public class Text0042 {


    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        if(len == 0) {
            return 0;
        }
        int sumMax = nums[0];
        int pre = 0;
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            sumMax = Math.max(pre, sumMax);
        }
        return sumMax;
    }

}
