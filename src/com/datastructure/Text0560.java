package com.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表-前缀和
 */
public class Text0560 {

    public int subarraySum(int[] nums, int k) {
        // 记录前缀和为key的数量
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, ans = 0;
        for (int num : nums) {
            sum += num;
            ans += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

}
