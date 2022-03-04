package com.datastructure;

/**
 * 哈希表
 */
public class Text0409 {

    public int longestPalindrome(String s) {
        // 记录每种字母的数量
        int[] hashCount = new int['z' - 'A' + 1];
        for (int i = 0; i < s.length(); i++) {
            hashCount[s.charAt(i) - 'A']++;
        }
        int oddCount = 0;
        for (int count : hashCount) {
            oddCount += count % 2;
        }
        return oddCount > 0 ? s.length() - oddCount + 1 : s.length();
    }

    public static void main(String[] args) {
    }

}
