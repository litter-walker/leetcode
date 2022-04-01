package com.general;

import java.util.Map;
import java.util.TreeMap;

/**
 * 优先队列
 */
public class Text0954 {

    public boolean canReorderDoubled(int[] arr) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>((a, b) -> {
            if (a < 0 && b < 0) {
                return b - a;
            } else {
                return a - b;
            }
        });
        for (int num : arr) {
            treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
        }

        while (!treeMap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = treeMap.pollFirstEntry();
            int key = entry.getKey();
            int value = entry.getValue();
            treeMap.put(key, value - 1);
            if (value == 1) {
                treeMap.remove(key);
            }
            if (!treeMap.containsKey(key * 2)) {
                return false;
            }
            treeMap.put(key * 2, treeMap.get(key * 2) - 1);
            if (treeMap.get(key * 2) == 0) {
                treeMap.remove(key * 2);
            }
        }
        return true;
    }
}
