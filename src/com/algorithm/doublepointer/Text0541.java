package com.algorithm.doublepointer;

/**
 * 双指针
 */
public class Text0541 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int n = s.length();
        // 每次的起始位置
        int start = 0;
        while (start < n) {
            int l = start, r = Math.min(start + k, n) - 1;
            while(l < r) {
                char temp = chars[l];
                chars[l] = chars[r];
                chars[r] = temp;
                l++;
                r--;
            }
            start += 2 * k;
        }
        return new String(chars);
    }
}
