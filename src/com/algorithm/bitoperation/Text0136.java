package com.algorithm.bitoperation;

/**
 * 位运算
 */
public class Text0136 {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

}
