package com.interview;

/**
 * 一次遍历
 */
public class Text01_05 {
    public boolean oneEditAway(String first, String second) {
        int m = first.length(), n = second.length();
        // 保证 first 比 second 长
        if (m - n < 0) {
            return oneEditAway(second, first);
        }
        // 保证 first 最多比 second 长 1
        if (m - n > 1) {
            return false;
        }
        int diffCount = 0;
        int i = 0, j = 0;
        while (i < m && j < n) {
            // 比较 first 和 second 的每一位是否相同
            if (first.charAt(i) == second.charAt(j)) {
                j++;
            } else {
                // 不同时，如果两个字符串一样长，那么应该交换才行
                if (m == n) {
                    j++;
                }
                // 不同时，如果两个字符串不一样长，那么应该将 frist 比较的数量后移；
                // 记录不一样的 字母数量
                diffCount++;
            }
            i++;
        }
        return diffCount <= 1 && ((diffCount <= 0) || (i == m && j == n));
    }
}
