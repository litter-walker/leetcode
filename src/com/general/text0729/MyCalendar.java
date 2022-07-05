package com.general.text0729;

import java.util.Map;
import java.util.TreeMap;

/**
 * 线段树（TreeMap 模拟）
 */
public class MyCalendar {
    private final TreeMap<Integer, Integer> calendar;
    public MyCalendar() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> low = calendar.lowerEntry(end);
        if (low != null && low.getValue() > start) {
            return false;
        }
        calendar.put(start, end);
        return true;
    }
}
