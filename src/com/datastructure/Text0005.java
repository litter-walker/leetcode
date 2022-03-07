package com.datastructure;

/**
 * 解题思路：
 * 1.暴力：时间O(n^3),空间O(n) 超时
 * 双指针-哈希表
 * 双指针： 判断是否是回文字符串；
 * 哈希表： 将字符分组
 * 2.中心扩展法：时间 O(n^2),空间O(1)
 * 3.动态规划：时间O(n^2),空间O(n^2)
 */
public class Text0005 {

    // 暴力解法：时间O(n^3)
/*
    public String longestPalindrome(String s) {
        int n = s.length();
        // 记录每个字符可以存在的位置
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            List<Integer> list = map.getOrDefault(ch, new ArrayList<>());
            list.add(i);
            map.putIfAbsent(ch, list);
        }
        String ans = "";
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            List<Integer> list = map.get(ch);
            for (Integer idx : list) {
                if (idx - i + 1 < ans.length()) {
                    break;
                }
                String str = s.substring(i, idx + 1);
                if (isPalindrome(str)) {
                    ans = str;
                }
            }
        }
        return ans;
    }

    */

    /**
     * 判断是否是回文字符串
     *
     * @param str 待定字符串
     * @return 是否是回文字符串
     */
    private boolean isPalindrome(String str) {
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    // 动态规划解法
    public String longestPalindrome(String s) {
        int n = s.length();
        // dp 数组
        boolean[][] isPalindrome = new boolean[n][n];
        int ansL = 0, ansR = 0;
        for (int subLen = 1; subLen <= n; subLen++) {
            for (int l = 0; l + subLen - 1 < n; l++) {
                int r = l + subLen - 1;
                char chL = s.charAt(l), chR = s.charAt(r);
                if (chL != chR) {
                    isPalindrome[l][r] = false;
                } else if (subLen <= 3) {
                    isPalindrome[l][r] = true;
                } else {
                    isPalindrome[l][r] = isPalindrome[l + 1][r - 1];
                }
                if (isPalindrome[l][r] && subLen > ansR - ansL + 1) {
                    ansL = l;
                    ansR = r;
                }
            }
        }
        return s.substring(ansL, ansR + 1);
    }

}
