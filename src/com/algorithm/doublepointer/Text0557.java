package com.algorithm.doublepointer;

/**
 * 双指针
 */
public class Text0557 {

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r;
        for (int i = 0; i <= chars.length; i++) {
            if (i == chars.length || chars[i] == ' ') {
                r = i - 1;
                while (l < r) {
                    char temp = chars[r];
                    chars[r] = chars[l];
                    chars[l] = temp;
                    l++;
                    r--;
                }
                l = i + 1;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println("s = " + s);
        System.out.println("new Text0557().reverseWords(s) = " + new Text0557().reverseWords(s));
    }

}
