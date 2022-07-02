package com.general.text0871;

import java.util.PriorityQueue;

/**
 * 贪心 + PQ
 */
public class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        int count = 0;
        PriorityQueue<Integer> fuelPQ = new PriorityQueue<>((a, b) -> b - a);
        int preV = 0;
        for (int i = 0; i <= n; i++) {
            int curV = i < n ? stations[i][0] : target;
            startFuel -= curV - preV;
            // 油不够，加油(前面没有加的油，优先加最多的油)
            while (!fuelPQ.isEmpty() && startFuel < 0) {
                startFuel += fuelPQ.poll();
                count++;
            }
            if (startFuel < 0) {
                return -1;
            }
            if (i < n) {
                fuelPQ.offer(stations[i][1]);
                preV = curV;
            }
        }
        return count;
    }
}
