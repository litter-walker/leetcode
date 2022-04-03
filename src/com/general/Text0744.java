package com.general;

/**
 * 二分查找
 */
public class Text0744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int ch = letters[mid];
            if (ch <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (l == n - 1 && letters[l] <= target) {
            return letters[0];
        }
        return letters[l];
    }
}
