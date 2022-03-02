package com.datastructure;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 贪心
 */
public class Text0435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int ans = 1, right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= right) {
                ans++;
                right = intervals[i][1];
            }
        }
        return intervals.length - ans;
    }

    public static void main(String[] args) {

    }
}
