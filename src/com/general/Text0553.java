package com.general;

/**
 * 解题思路：
 *  思考：要是最后的结果最大，应该将第一个后面的全部括到一起
 */
public class Text0553 {

    public String optimalDivision(int[] nums) {
        if (nums.length == 1) {
            return nums[0] + "";
        } else if (nums.length == 2) {
            return nums[0] + "/" + nums[1];
        }
        StringBuilder ansSbd = new StringBuilder();
        ansSbd.append(nums[0]).append("/(").append(nums[1]);
        for (int i = 2; i < nums.length; i++) {
            ansSbd.append("/").append(nums[i]);
        }
        ansSbd.append(")");
        return ansSbd.toString();
    }

    public static void main(String[] args) {

    }


}
