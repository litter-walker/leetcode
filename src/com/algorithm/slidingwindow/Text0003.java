package com.algorithm.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口
 */
public class Text0003 {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int r = 0, l = -1; r < s.length(); r++) {
            if (map.containsKey(s.charAt(r))) {
                l = Math.max(map.get(s.charAt(r)), l);
            }
            map.put(s.charAt(r), r);
            maxLen = Math.max(maxLen, r - l);
        }
        return maxLen;
    }
}
