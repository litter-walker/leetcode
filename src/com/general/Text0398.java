package com.general;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;


public class Text0398 {
}

/**
 * 哈希表
 */
class Solution {

    private final Map<Integer, List<Integer>> numIdx = new HashMap<>();
    ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

    public Solution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            List<Integer> idxList = numIdx.getOrDefault(nums[i], new ArrayList<>());
            idxList.add(i);
            numIdx.putIfAbsent(nums[i], idxList);
        }
    }

    public int pick(int target) {
        List<Integer> idxList = numIdx.get(target);
        return idxList.get(threadLocalRandom.nextInt(idxList.size()));
    }
}
