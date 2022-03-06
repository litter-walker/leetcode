package com.datastructure;

import java.util.*;

/**
 * 哈希表-排序
 */
public class Text0049 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.put(key, map.getOrDefault(key, new ArrayList<>()));
            map.get(key).add(str);
        }
        List<List<String>> ans = new ArrayList<>();
        map.forEach((a, b)->ans.add(b));
        return ans;
    }
}
