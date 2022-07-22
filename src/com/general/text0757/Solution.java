package com.general.text0757;

import java.util.Arrays;

/**
 * 排序-贪心-分类讨论 <p>
 * 参考思路：
 * <a href="https://leetcode.cn/problems/set-intersection-size-at-least-two/solution/by-flix-fmam/">
 *     『 最简贪心解法 』O(nlogn)：排序+贪心+分类讨论
 * </a>
 */
public class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        int ans = 2;
        int end = intervals[0][1], preEnd = intervals[0][1] - 1;
        for (int[] interval : intervals) {
            if (interval[0] > preEnd && interval[0] <= end) {
                ans++;
                preEnd = end;
                end = interval[1];
            } else {
                ans += 2;
                end = interval[1];
                preEnd = end - 1;
            }
        }
        return ans;
    }
}
