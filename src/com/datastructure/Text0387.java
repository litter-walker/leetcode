package com.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * 两次遍历
 */
public class Text0387 {

    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int count = map.getOrDefault(ch, 0);
            if (count == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "ll";
        System.out.println("s = " + s);
        System.out.println("firstUniqChar(s) = " + firstUniqChar(s));
    }
}
