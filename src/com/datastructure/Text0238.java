package com.datastructure;

/**
 * 前缀积-后缀积
 */
public class Text0238 {

    public int[] productExceptSelf(int[] nums) {
        // 用于记录后缀积
        int[] answer = new int[nums.length];
        answer[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            answer[i] = answer[i + 1] * nums[i + 1];
        }
        // 记录前缀积
        int pre = 1;
        for (int i = 0; i < nums.length; i++) {
            answer[i] *= pre;
            pre *= nums[i];
        }
        return answer;
    }

}
