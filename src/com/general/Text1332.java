package com.general;

/**
 * 解题思路：
 *  题目是删除回文 子序列 而不是 子串（可以不连续）
 *      可知最大删除次数为2次，即一次删除所有的a，一次删除所有的b
 *
 *      特殊情况：字符串本来就是回文字符串，只需要删除一次即可；
 */
public class Text1332 {

    public static int removePalindromeSub(String s) {

        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return 2;
            }
            l++;
            r--;
        }
        return 1;
    }

    public static void main(String[] args) {
        String s = "baabb";
        System.out.println("s = " + s);
        System.out.println("removePalindromeSub(s) = " + removePalindromeSub(s));
    }

}
