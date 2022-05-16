package com.general;

/**
 * 简单模拟
 */
public class Text0944 {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        int m = strs.length, n = strs[0].length();
        if (m <= 1) {
            return count;
        }
        for (int col = 0; col < n; col++) {
            for (int row = 1; row < m; row++) {
                if (strs[row].charAt(col) < strs[row - 1].charAt(col)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
