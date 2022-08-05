package com.weekly.week0304.text03;

import java.util.HashMap;
import java.util.Map;

/*
    哈希表
 */
public class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(-1, -1);
        for (int i = 0; !map1.containsKey(node1); i++) {
            map1.put(node1, i);
            node1 = edges[node1];
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        map2.put(-1, -1);
        int ans = -1, minDis = Integer.MAX_VALUE;
        for (int i = 0; !map2.containsKey(node2); i++) {
            map2.put(node2, i);
            if (map1.containsKey(node2)) {
                int curDis = Math.max(map1.get(node2), i);
                if (curDis < minDis || (curDis == minDis && node2 < ans)) {
                    minDis = curDis;
                    ans = node2;
                }
            }
            node2 = edges[node2];
        }

        return ans;
    }
}
