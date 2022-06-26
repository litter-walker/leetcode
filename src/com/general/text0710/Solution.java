package com.general.text0710;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * 线段树-前缀和<p>
 *  统计白名单区间，使用前缀和，统计数量，加快索引效率<p>
 * 该方法 空间 和 时间 的开销都很大;<p>
 *
 * 更高效的算法参考：
 * <a href="https://leetcode.cn/problems/random-pick-with-blacklist/solution/hei-ming-dan-zhong-de-sui-ji-shu-by-jian-8qgj/">黑名单中的随机数【哈希映射】</a>
 */
class Solution {

    // <K, V> 表示 将V以及前面的区间包含的白名单数量为 K
    private final TreeMap<Integer, Map.Entry<Integer, Integer>> countWhite;
    // 记录白名单数量
    private final int count;
    private final Random random;

    public Solution(int n, int[] blacklist) {
        count = n - blacklist.length;
        random = new Random();
        // 记录白名单的全部区间(左闭右开)
        TreeMap<Integer, Integer> whitelist = new TreeMap<>();
        whitelist.put(0, n);
        for (int black : blacklist) {
            Map.Entry<Integer, Integer> entry = whitelist.floorEntry(black);
            int value = entry.getValue();
            int key = entry.getKey();
            if (black != value - 1) {
                whitelist.put(black + 1, value);
            }
            if (black != key) {
                whitelist.put(key, black);
            } else {
                whitelist.remove(key);
            }
        }
        int sum = 0;
        countWhite = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : whitelist.entrySet()) {
            sum += entry.getValue() - entry.getKey();
            countWhite.put(sum, entry);
        }
    }

    public int pick() {
        int idx = random.nextInt(count) + 1;
        Map.Entry<Integer, Map.Entry<Integer, Integer>> entry = countWhite.ceilingEntry(idx);
        int num = entry.getKey();
        int end = entry.getValue().getValue();
        return end - 1 - (num - idx);
    }
}