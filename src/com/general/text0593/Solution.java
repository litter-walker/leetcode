package com.general.text0593;

import java.util.HashMap;
import java.util.Map;

/**
 * 数学问题：
 *  正方形满足一下两个条件：
 *      菱形：四条边相等
 *      正方形：对角线相等的菱形
 */
public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Map<Integer, Integer> map = new HashMap<>();
        int[][] points = new int[][]{p1, p2, p3, p4};
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int key = distance(points[i], points[j]);
                if (key == 0) {
                    return false;
                }
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        if (map.size() != 2) {
            return false;
        }
        int a = 0, b = 0;
        for (int dis : map.keySet()) {
            if (a == 0) {
                a = dis;
            } else {
                b = dis;
            }
        }
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        return (a * 2) == b && map.get(a) == 4 && map.get(b) == 2;
    }

    private int distance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
