package com.datastructure;

import java.util.Arrays;
import java.util.Random;

/**
 * 计算数组的前缀和：
 *  遍历数组，当前前缀和-前面的最小前缀和；
 */
public class Text0053 {

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int minPrefixSum = 0;
        int curPrefixSum = 0;
        int maxSubSum = nums[0];
        for (int num : nums) {
            curPrefixSum += num;
            maxSubSum = Math.max(curPrefixSum - minPrefixSum, maxSubSum);
            minPrefixSum = Math.min(minPrefixSum, curPrefixSum);
        }
        return maxSubSum;
    }

    /**
     * 官方题解：动态规划： 是否将第i个数据，添加到子序列中
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        int maxSubSum = nums[0];
        int pre = 0;
        for (int num : nums) {
            pre = Math.max(num, pre + num);
            maxSubSum = Math.max(maxSubSum, pre);
        }
        return maxSubSum;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int n = 10;
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(10000);
        }
        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("maxSubArray(nums) = " + maxSubArray(nums));
        System.out.println("maxSubArray1(nums) = " + maxSubArray1(nums));
    }
}
