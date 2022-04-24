package com.general;

/**
 * 简单模拟
 */
public class Text0868 {

    public int binaryGap(int n) {
        int lIdx = -1;
        while (n > 0) {
            if ((n & 1) == 1) {
                break;
            }
            lIdx++;
            n >>= 1;
        }
        int rIdx = lIdx;
        int maxDistance = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                maxDistance = Math.max(maxDistance, rIdx - lIdx);
                lIdx = rIdx;
            }
            rIdx++;
            n >>= 1;
        }
        return maxDistance;
    }

}
