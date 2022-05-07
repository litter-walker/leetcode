package com.general.text0933;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 */
public class RecentCounter {

    private final Deque<Integer> que;

    public RecentCounter() {
        que = new LinkedList<>();
    }

    public int ping(int t) {
        que.offer(t);
        while (!que.isEmpty() && t - que.peek() > 3000) {
            que.poll();
        }
        return que.size();
    }
}
