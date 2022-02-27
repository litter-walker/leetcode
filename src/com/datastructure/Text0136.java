package com.datastructure;

/**
 * 解题思路：
 *  异或
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
