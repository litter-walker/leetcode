package com.day04;

import java.util.Arrays;

public class test2 {

    public static String reverseWords(String s) {
        // 使用双指针，将字符串反转；
        int l = 0;
        int r = s.length() - 1;
        char[] chs = s.toCharArray();
        while (l < r) {
            char temp = chs[l];
            chs[l] = chs[r];
            chs[r] = temp;
            l++;
            r--;
        }
        // 按 ‘ ’ 分割字符串，为子字符串
        s = new String(chs);
        String[] split = s.split(" ");
        // 使用双指针，反转子字符串的位置
        l = 0;
        r = split.length - 1;
        while (l < r) {
            String temp = split[l];
            split[l] = split[r];
            split[r] = temp;
            l++;
            r--;
        }
        // 将子字符串拼接
        s = String.join(" ", split);
        return s;
    }


    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";


        System.out.println(reverseWords(s));

    }

}
