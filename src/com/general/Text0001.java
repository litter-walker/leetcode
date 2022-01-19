package com.general;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Text0001 {

    public static int[] twoSum(int[] nums, int target) {

        int[] ans = new int[2];
        // 记录位置
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;
        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("target = " + target);
        System.out.println("twoSum(nums, target) = " + Arrays.toString(twoSum(nums, target)));
    }

}
