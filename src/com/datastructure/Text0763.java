package com.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 哈希表-贪心-双指针
 */
public class Text0763 {

    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();

        // 记录每个字母，最后出现的位置
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        int l = 0, r = map.get(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            r = Math.max(r, map.get(s.charAt(i)));
            if (i == r) {
                ans.add(r + 1 - l);
                l = i + 1;
            }
        }
        return ans;
    }

}
