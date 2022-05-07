package com.general;

import java.util.*;

/**
 * BFS
 */
public class Text0433 {

    public int minMutation(String start, String end, String[] bank) {

        Set<String> set = new HashSet<>();
        Set<String> visited = new HashSet<>();
        Collections.addAll(set, bank);

        if (start.equals(end)) {
            return 0;
        }
        if (!set.contains(end)) {
            return -1;
        }

        char[] dirs = {'A', 'C', 'G', 'T'};
        Deque<String> que = new LinkedList<>();
        que.offer(start);
        visited.add(start);
        int ans = 1;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                String poll = que.poll();
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (poll != null && dirs[k] != poll.charAt(j)) {
                            StringBuilder cur = new StringBuilder(poll);
                            cur.setCharAt(j, dirs[k]);
                            String next = cur.toString();
                            if (!visited.contains(next) && set.contains(next)) {
                                if (next.equals(end)) {
                                    return ans;
                                }
                                que.offer(next);
                                visited.add(next);
                            }
                        }
                    }
                }
            }
            ans++;
        }
        return -1;
    }

}
