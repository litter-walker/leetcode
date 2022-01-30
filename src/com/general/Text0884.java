package com.general;

import java.util.*;

/**
 * 解题思路：
 * 直接使用Map记录每个单词出现的次数;
 * 两个字符串中，一共只出现一次的单词为 不常见单词
 */
public class Text0884 {
    public static String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : s1.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : s2.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<String> uncommonWord = new ArrayList<>();
        map.forEach((k, v) -> {
            if (v == 1) {
                uncommonWord.add(k);
            }
        });
        return uncommonWord.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String s1 = "apple apple", s2 = "banana";
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("uncommonFromSentences(s1, s2) = " + Arrays.toString(uncommonFromSentences(s1, s2)));
    }

}
