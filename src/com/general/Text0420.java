package com.general;

/**
 * 分类讨论，无意义题目
 */
public class Text0420 {

    public int strongPasswordChecker(String password) {
        int n = password.length();
        int lowerCase = 0, upperCase = 0, number = 0;
        for (int i = 0; i < n; ++i) {
            char ch = password.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                lowerCase = 1;
            } else if (ch >= '0' && ch <= '9') {
                number = 1;
            } else if (ch >= 'A' && ch <= 'Z') {
                upperCase = 1;
            }
        }
        int type = lowerCase + upperCase + number;
        if (n < 6) {
            return Math.max(6 - n, 3 - type);
        } else if (n <= 20) {
            int replace = 0;
            // 记录相同字符连续的数量
            int count = 0;
            char pre = 0, cur;
            for (int i = 0; i < n; ++i) {
                cur = password.charAt(i);
                if (cur == pre) {
                    ++count;
                } else {
                    replace += count / 3;
                    count = 1;
                    pre = cur;
                }
            }
            replace += count / 3;
            return Math.max(replace, 3 - type);
        } else {
            int replace = 0, delete = n - 20;
            int del2 = 0; // 记录多于 mod == 1 时的情况
            // 记录相同字符连续的数量
            int count = 0;
            char pre = 0, cur;
            for (int i = 0; i < n; ++i) {
                cur = password.charAt(i);
                if (cur == pre) {
                    ++count;
                } else {
                    if (delete > 0 && count >= 3) {
                        if (count % 3 == 0) {
                            --replace;
                            --delete;
                        } else if (count % 3 == 1) {
                            ++del2;
                        }
                    }
                    replace += count / 3;
                    count = 1;
                    pre = cur;
                }
            }
            if (delete > 0 && count >= 3) {
                if (count % 3 == 0) {
                    --replace;
                    --delete;
                } else if (count % 3 == 1) {
                    ++del2;
                }
            }
            replace += count / 3;
            int use2 = Math.min(del2, delete / 2);
            replace -= use2;
            delete -= use2 * 2;
            replace -= delete / 3;
            return (n - 20) + Math.max(replace, 3 - type);
        }
    }

}
