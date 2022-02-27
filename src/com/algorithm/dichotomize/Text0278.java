package com.algorithm.dichotomize;

/**
 * 二分
 */
public class Text0278 {
    public int firstBadVersion(int n) {
        int l = 0;
        while (l < n) {
            int mid = l + (n - l) / 2;
            if (isBadVersion(mid)) {
                n = mid;
            } else {
                l = mid + 1;
            }
        }
        return n;
    }
    private boolean isBadVersion(int version) {
        return version % 2 == 0;
    }
}
