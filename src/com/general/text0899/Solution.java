package com.general.text0899;

import java.util.Arrays;

/*
    分类讨论：
        1. k == 1 时，只能进行轮转字符串
        2. k >= 1 时，前面至少有两个空位，那么可以将一个空位用来进行k后面的字符的轮转，
            前k个字符可以进行在任意时刻加入轮转；
            因此，此时应该是 s 的字符排序后的字符串
 */
public class Solution {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String ans = s;
            StringBuilder sb = new StringBuilder(s);
            for (int i = 1; i < s.length(); i++) {
                char ch = sb.charAt(0);
                sb.deleteCharAt(0).append(ch);
                if (ans.compareTo(sb.toString()) > 0) {
                    ans = sb.toString();
                }
            }
            return ans;
        } else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }
}
