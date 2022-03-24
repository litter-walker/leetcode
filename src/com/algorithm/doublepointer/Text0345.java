package com.algorithm.doublepointer;

/**
 * 双指针
 */
public class Text0345 {
    public String reverseVowels(String s) {
        String vowel = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r) {
            char chl = chars[l];
            while (l < r && vowel.indexOf(chl) == -1) {
                l++;
                chl = chars[l];
            }
            char chr = s.charAt(r);
            while (l < r && vowel.indexOf(chr) == -1) {
                r--;
                chr = chars[r];
            }
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
        return new String(chars);
    }
}
