package com.algorithm.firstsearch;

import java.util.*;

/**
 * 哈希表：
 *
 * 时间： O(n)
 * 空间： O(mn) m = 10; 因此，可为O(n)
 */
public class Text0187 {

    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        if (n < 11) {
            return Collections.emptyList();
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 10; i <= n; i++) {
            String str = s.substring(i - 10, i);
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 2) {
                ans.add(entry.getKey());
            }
        }
        return ans;
    }
}
