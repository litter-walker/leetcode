package com.general;

import java.util.Map;
import java.util.TreeMap;

/**
 * 差分
 */
public class Text0732 {

    private final TreeMap<Integer, Integer> map = new TreeMap<>();

//    public MyCalendarThree() {
//    }

    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int ans = 0, cur = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            cur += entry.getValue();
            ans = Math.max(cur, ans);
        }
        return ans;
    }

}
