package com.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * 解题思路：
 *  HashMap计数：时间、空间复杂度均为 O(n);
 *
 *  方法二： 官方解法（摩尔投票法）
 *      众数的数量一定大于其他的数量的和
 *      时间 O(n), 空间 O(1)
 */
public class Text0169 {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }
        return -1;
    }

}
