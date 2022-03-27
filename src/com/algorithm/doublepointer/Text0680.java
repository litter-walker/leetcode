package com.algorithm.doublepointer;

/**
 * 解题思路：
 *  使用双指针遍历判断是否为回文字符串；
 *
 *  删除问题解决：
 *      例：abcca 删除 b；
 *          accba 删除 b；
 *          acdcda 删除 c 或者 d
 */

public class Text0680 {

    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return validPalindrome(s, l + 1, r) || validPalindrome(s, l, r - 1);
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean validPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
