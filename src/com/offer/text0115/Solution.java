package com.offer.text0115;

import java.util.*;

/**
 * 拓扑排序
 */
public class Solution {
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int n = nums.length;
        int[] inCount = new int[n + 1];
        Map<Integer, Set<Integer>> outMap = new HashMap<>();

        // 建图
        for (int[] sequence : sequences) {
            for (int i = 1; i < sequence.length; i++) {
                int from = sequence[i - 1], to = sequence[i];
                outMap.putIfAbsent(from, new HashSet<>());
                if (outMap.get(from).add(to)) {
                    inCount[to]++;
                }
            }
        }

        Queue<Integer> que = new ArrayDeque<>();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (inCount[i] == 0) {
                que.offer(i);
            }
        }
        while (!que.isEmpty()) {
            if (que.size() > 1) {
                return false;
            }
            int poll = que.poll();
            count++;
            Set<Integer> outSet = outMap.get(poll);
            if (outSet == null) {
                continue;
            }
            for (int next : outSet) {
                inCount[next]--;
                if (inCount[next] == 0) {
                    que.offer(next);
                }
            }
        }
        return count == n;
    }
}