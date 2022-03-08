package com.general;

import java.util.Arrays;

/**
 * 前缀和-双指针
 */
public class Text2055 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        // counts[i] 表示 0~i 个字符中的，蜡烛之间的盘子数量
        int[] counts = new int[n];
        int l = -1;
        for (int r = 0; r < n; r++) {
            char ch = s.charAt(r);
            if (ch == '|') {
                if (l > -1) {
                    counts[r] = counts[r - 1] + r - l - 1;
                }
                l = r;
            } else if (r != 0) {
                counts[r] = counts[r - 1];
            }
        }
        int[] nextIdx = new int[n];
        int idx = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                idx = i;
            }
            nextIdx[i] = idx;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int queryL = queries[i][0], queryR = queries[i][1];
            if (nextIdx[queryL] <= queryR) {
                ans[i] = counts[queryR] - counts[nextIdx[queryL]];
            } else {
                ans[i] = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "***|**|*****|**||**|*";
        int[][] queries = {{1,17},{4,5},{14,17},{5,11},{15,16}};
        System.out.println("new Text2055().platesBetweenCandles(s, queries) = " + Arrays.toString(new Text2055().platesBetweenCandles(s, queries)));
    }
}
