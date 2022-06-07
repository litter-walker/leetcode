package com.general;

/**
 * 二分查找：
 *  k 值 一定小于等于 piles[i]
 */
public class Text0875 {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            int needTime = needTime(piles, mid);
            if (needTime > h) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int needTime(int[] piles, int mid) {
        int time = 0;
        for (int pile : piles) {
            time += pile / mid;
            if (pile % mid != 0) {
                time++;
            }
        }
        return time;
    }
}
