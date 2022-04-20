package com.general;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 哈希表
 */
public class Text0819 {

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for (String str : banned) {
            bannedSet.add(str.toLowerCase());
        }
        Map<String, Integer> map = new HashMap<>();
        for (String str : paragraph.replaceAll("[^A-Za-z]", " ").split(" ")) {
            String lowStr = str.toLowerCase();
            if (!bannedSet.contains(lowStr) && !lowStr.equals("")) {
                map.put(lowStr, map.getOrDefault(lowStr, 0) + 1);
            }
        }
        String ans = "";
        int count = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > count) {
                ans = entry.getKey();
                count = entry.getValue();
            }
        }
        return ans;
    }

}
