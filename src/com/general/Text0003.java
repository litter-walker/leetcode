package com.general;

import java.util.HashMap;
import java.util.Map;

public class Text0003 {

    public static int lengthOfLongestSubstring(String s) {
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

    public static void main(String[] args) {
        String s = "aabaskjch";
        System.out.println("s = " + s);
        System.out.println("lengthOfLongestSubstring(s) = " + lengthOfLongestSubstring(s));
    }
}
