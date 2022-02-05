package com.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Text0383 {

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) - 1);
            if (map.get(ch) == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "ab";
        System.out.println("ransomNote = " + ransomNote);
        System.out.println("magazine = " + magazine);
        System.out.println("canConstruct(ransomNote, magazine) = " + canConstruct(ransomNote, magazine));
    }
}
