package com.algorithm.doublepointer;

/**
 * 双指针
 */
public class Text0125 {

    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            char chl = Character.toLowerCase(s.charAt(l));
            while (l < r && !((chl >= 'A' && chl <= 'Z') || (chl >= 'a' && chl <= 'z') || (chl >= '0' && chl <= '9'))) {
                l++;
                chl = Character.toLowerCase(s.charAt(l));
            }
            char chr = Character.toLowerCase(s.charAt(r));
            while (l < r && !((chr >= 'A' && chr <= 'Z') || (chr >= 'a' && chr <= 'z') || (chr >= '0' && chr <= '9'))) {
                r--;
                chr = Character.toLowerCase(s.charAt(r));
            }
            if (l < r && chl != chr) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
