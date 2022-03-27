package com.algorithm.doublepointer;


import java.util.Arrays;

/**
 * 双指针解法：
 * 遍历数组：获得第一个数字
 * 第二和三个数字使用双指针得到
 */
public class Text0016 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = nums[0] + nums[1] + nums[2];
        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int second = first + 1, third = n - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                if (sum < target) {
                    second++;
                } else {
                    third--;
                }
            }
        }
        return ans;
    }
}
