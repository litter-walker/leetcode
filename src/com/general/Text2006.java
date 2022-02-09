package com.general;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 一次遍历
 * 使用哈希表记录以及遍历的每个数字的数量，
 * 时间、空间均为O(n)
 */
public class Text2006 {

    public static int countKDifference(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num + k, 0) + map.getOrDefault(num - k, 0);
            ans += count;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,1};
        int k = 1;
        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("k = " + k);
        System.out.println("countKDifference(nums) = " + countKDifference(nums, k));
    }
}
