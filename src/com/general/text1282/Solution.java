package com.general.text1282;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    哈希表
 */
public class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int size = groupSizes[i];
            List<Integer> list = map.getOrDefault(size, new ArrayList<>());
            list.add(i);
            map.put(size, list);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int size = entry.getKey();
            List<Integer> person = entry.getValue();
            List<Integer> group = new ArrayList<>();
            for (int i = 0; i < person.size(); i++) {
                group.add(person.get(i));
                if ((i + 1) % size == 0) {
                    ans.add(group);
                    group = new ArrayList<>();
                }
            }
        }
        return ans;
    }
}
