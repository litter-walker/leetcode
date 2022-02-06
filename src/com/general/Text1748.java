package com.general;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表法
 */
public class Text1748 {

    public static int sumOfUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                sum += entry.getKey();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,2};
        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("sumOfUnique(nums) = " + sumOfUnique(nums));
    }
}
