package com.general;

/**
 * 1.简单模拟：
 * 2.字符串拼接
 */
public class Text0796 {

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == goal.charAt(0)) {
                int j;
                for (j = 0; j < n; j++) {
                    if (s.charAt((i + j) % n) != goal.charAt(j)) {
                        break;
                    }
                }
                if (j == n) {
                    return true;
                }
            }
        }
        return false;
    }

}
