package com.datastructure.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 优先队列
 */
public class Text0973 {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0] * a[0] + a[1] * a[1]));
        for (int[] point : points) {
            pq.offer(point);
        }
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }


}
