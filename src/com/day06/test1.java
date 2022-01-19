package com.day06;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class test1 {

    public static int lengthOfLongestSubstring(String s) {
        int strMax = 0;
        int l = 0, r = 0;

        Set<Character> set = new HashSet<>();
        while(r < s.length()) {
            set.add(s.charAt(r));
            r++;

            while (s.charAt(l) != 'a') {
                l++;
            }

        }


        return strMax;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";


        System.out.println(lengthOfLongestSubstring(s));
    }

}
