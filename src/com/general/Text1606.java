package com.general;

import java.util.*;

/**
 * 模拟 + 有序集合 + 优先队列
 */
public class Text1606 {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int maxCount = 0;
        int[] counts = new int[k];
        PriorityQueue<int[]> busy = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
        TreeSet<Integer> free = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            free.add(i);
        }
        for (int i = 0; i < arrival.length; i++) {
            int start = arrival[i], end = arrival[i] + load[i];
            while (!busy.isEmpty() && busy.peek()[1] <= start) {
                int[] poll = busy.poll();
                free.add(poll[0]);
            }
            if (free.isEmpty()) {
                continue;
            }
            Integer p = free.ceiling(i % k);
            if (p == null) {
                p = free.first();
            }
            maxCount = Math.max(++counts[p], maxCount);
            busy.offer(new int[]{p, end});
            free.remove(p);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == maxCount) {
                ans.add(i);
            }
        }
        return ans;
    }

}
