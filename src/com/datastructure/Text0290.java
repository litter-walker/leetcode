package com.datastructure;

import java.util.HashSet;
import java.util.Set;

/**
 * 哈希表-贪心
 */
public class Text0290 {

    public boolean wordPattern(String pattern, String s) {
        String[] ss = s.split(" ");
        if (ss.length != pattern.length()) {
            return false;
        }
        String[] map = new String[26];
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (map[ch - 'a'] == null) {
                map[ch - 'a'] = ss[i];
            } else if (!map[ch - 'a'].equals(ss[i])) {
                return false;
            }
        }
        Set<String> set = new HashSet<>();
        for (String str : map) {
            if (str != null &&!set.add(str)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba", str = "dog cat cat dog";
        System.out.println("new Text0290().wordPattern(pattern, str) = " + new Text0290().wordPattern(pattern, str));
    }
}
