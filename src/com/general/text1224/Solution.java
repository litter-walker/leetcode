package com.general.text1224;


import java.util.HashMap;
import java.util.Map;

/*
    哈希表：（官方题解）
        1. 当只有一组数据时，满足条件
        2. 当频率最大为 1 时， 满足条件
        3. 当只有两种频率，且存在一个频率为 1， 满足条件
        4. 当只有两种频率 maxFreq 的数量为 1, 且元素总和为 maxFreq，其它均为 maxFreq - 1
 */
public class Solution {
    public int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        Map<Integer, Integer> freqCutMap = new HashMap<>();
        int ans = 0, maxFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            int freq = freqMap.getOrDefault(nums[i], 0);
            // 以前的频率数量 -1
            if (freq > 0) {
                int count = freqCutMap.get(freq) - 1;
                if (count == 0) {
                    freqCutMap.remove(freq);
                } else {
                    freqCutMap.put(freq, count);
                }
            }
            freq++;
            freqMap.put(nums[i], freq);
            // 现在的频率数量 +1
            int count = freqCutMap.getOrDefault(freq, 0) + 1;
            freqCutMap.put(freq, count);

            maxFreq = Math.max(maxFreq, freq);
            boolean flag1 = freqMap.size() == 1;
            boolean flag2 = maxFreq == 1;
            boolean flag3 = freqCutMap.size() == 2 && freqCutMap.getOrDefault(1, 0) == 1;
            boolean flag4 = freqCutMap.size() == 2 && freqCutMap.get(maxFreq) == 1 && freqCutMap.containsKey(maxFreq - 1);
            if (flag1 || flag2 || flag3 || flag4) {
                ans = i + 1;
            }
        }
        return ans;
    }
}