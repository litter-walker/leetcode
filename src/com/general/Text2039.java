package com.general;

import java.util.*;

/**
 * BFS
 */
@SuppressWarnings("all")
public class Text2039 {

    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        List<Integer>[] edgeList = new List[n];
        for (int i = 0; i < edgeList.length; i++) {
            edgeList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            edgeList[edge[0]].add(edge[1]);
            edgeList[edge[1]].add(edge[0]);
        }
        int ans = 0;
        boolean[] visited = new boolean[n];
        Deque<Integer> que = new LinkedList<>();
        que.offer(0);
        visited[0] = true;
        int dis = 1;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int poll = que.poll();
                for (Integer next : edgeList[poll]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        que.offer(next);
                        int time = 4 * dis - (2 * dis) % patience[next] + 1;
                        ans = Math.max(ans, time);
                    }
                }
            }
            dis++;
        }
        return ans;
    }

}
