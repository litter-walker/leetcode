package com.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 哈希表
 */
public class Text0599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        // 将 值设为key，下标设为value
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        List<String> ans = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            String key = list2[i];
            if (map.containsKey(key)) {
                int idx = map.get(key);
                if (idx + i < minSum) {
                    minSum = idx + i;
                    ans = new ArrayList<>(){{add(key);}};
                } else if (idx + i == minSum) {
                    ans.add(key);
                }
            }
        }
        return ans.toArray(new String[0]);
    }
}
