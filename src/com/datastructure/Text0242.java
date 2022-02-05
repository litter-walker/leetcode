package com.datastructure;

import java.util.HashMap;

/**
 * Hash表；两次遍历
 */
public class Text0242 {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) - 1);
            if (map.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "rat", t = "car";
        System.out.println("s = " + s);
        System.out.println("t = " + t);
        System.out.println("isAnagram(s, t) = " + isAnagram(s, t));
    }
}
