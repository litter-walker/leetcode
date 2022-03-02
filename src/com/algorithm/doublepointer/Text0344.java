package com.algorithm.doublepointer;

/**
 * 双指针：使用双指针交换字符串
 */
public class Text0344 {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
