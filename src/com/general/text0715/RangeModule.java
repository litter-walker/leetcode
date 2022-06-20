package com.general.text0715;

import java.util.Map;
import java.util.TreeMap;

/**
 * 官方题解：有序集合/有序映射
 */
public class RangeModule {

    private final TreeMap<Integer, Integer> map;

    public RangeModule() {
        map = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        Map.Entry<Integer, Integer> entry = map.higherEntry(left);
        if (entry != map.firstEntry()) {
            Map.Entry<Integer, Integer> start = entry != null ? map.lowerEntry(entry.getKey()) : map.lastEntry();
            if (start != null && start.getValue() >= right) {
                return;
            }
            if (start != null && start.getValue() >= left) {
                left = start.getKey();
                map.remove(start.getKey());
            }
        }
        while (entry != null && entry.getKey() <= right) {
            right = Math.max(right, entry.getValue());
            map.remove(entry.getKey());
            entry = map.higherEntry(entry.getKey());
        }
        map.put(left, right);
    }

    public boolean queryRange(int left, int right) {
        Map.Entry<Integer, Integer> entry = map.higherEntry(left);
        if (entry == map.firstEntry()) {
            return false;
        }
        entry = entry != null ? map.lowerEntry(entry.getKey()) : map.lastEntry();
        return entry != null && entry.getValue() >= right;
    }

    public void removeRange(int left, int right) {
        Map.Entry<Integer, Integer> entry = map.higherEntry(left);
        if (entry != map.firstEntry()) {
            Map.Entry<Integer, Integer> start = entry != null ? map.lowerEntry(entry.getKey()) : map.lastEntry();
            if (start != null && start.getValue() >= right) {
                int end = start.getValue();
                if (start.getKey() == left) {
                    map.remove(start.getKey());
                } else {
                    map.put(start.getKey(), left);
                }
                if (right != end) {
                    map.put(right, end);
                }
                return;
            } else if (start != null && start.getValue() > left) {
                map.put(start.getKey(), left);
            }
        }
        while (entry != null && entry.getKey() < right) {
            if (entry.getValue() <= right) {
                map.remove(entry.getKey());
                entry = map.higherEntry(entry.getKey());
            } else {
                map.remove(entry.getKey());
                map.put(right, entry.getValue());
                break;
            }
        }
    }
}
