package com.general.text1403;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    排序 + 前缀和
 */
public class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        int curSum = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            curSum += nums[i];
            ans.add(nums[i]);
            if (curSum > sum - curSum) {
                break;
            }
        }
        return ans;
    }
}
