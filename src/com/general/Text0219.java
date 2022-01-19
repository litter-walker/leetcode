package com.general;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Text0219 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i - map.getOrDefault(nums[i], -(k + 1)) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,1};
        int k = 3;
        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("k = " + k);
        System.out.println("containsNearbyDuplicate(nums, k) = " + containsNearbyDuplicate(nums, k));
    }
}
