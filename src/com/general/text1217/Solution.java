package com.general.text1217;

/**
 * 奇偶计数
 */
public class Solution {
    public int minCostToMoveChips(int[] position) {
        int even = 0, add = 0;
        for (int p : position) {
            if ((p & 1) == 1) {
                add++;
            } else {
                even++;
            }
        }
        return Math.min(add, even);
    }
}
