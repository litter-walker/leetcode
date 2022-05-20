package com.general;

import java.util.*;

/**
 * 排序+优先队列
 */
public class Text0436 {

    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        // 用于记录下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(intervals[i][0], i);
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
        for (int[] interval : intervals) {
            // 先加入队列，防止出现start==end的情况
            pq.offer(interval);
            while (!pq.isEmpty() && pq.peek()[1] <= interval[0]) {
                int[] poll = pq.poll();
                ans[map.get(poll[0])] = map.get(interval[0]);
            }
        }
        return ans;
    }

}
