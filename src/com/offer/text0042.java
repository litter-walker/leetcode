package com.offer;

public class text0042 {


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


    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int sumMax = maxSubArray(nums);
        System.out.println("sumMax = " + sumMax);
    }
}
