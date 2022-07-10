package com.general.text0741;

import java.util.Arrays;

/**
 * 动态规划：
 *  可以将两次采摘，看作是两个人同时从(0, 0)开始采摘；
 *  设置状态转移方程:
 *      1. dp[k][x1][x2] 表示两人同时走 k 步后，第一个人在 (x1, k - x1), 第二个人在 (x2, k - x2) 的采摘苹果数量
 *
 *      2. 当 k = 2 * n - 2 时， 两人同时到达 (n - 1, n - 1)
 *
 *  最终答案为：dp[2 * n - 2][n - 1][n - 1]
 *  由于 dp[k] 由 dp[k - 1] 得来，因此可以(通过反向遍历)压缩一个维度；
 */
public class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        // 预处理
        check(grid);
        if (grid[n - 1][n - 1] == -1) {
            return 0;
        }

        int maxStep = 2 * n - 1;
        int[][][] dp = new int[maxStep][n][n];
        for (int[][] arrays : dp) {
            for (int[] arr : arrays) {
                Arrays.fill(arr, -1);
            }
        }
        dp[0][0][0] = grid[0][0];
        for (int k = 1; k < maxStep; k++) {
            for (int x1 = Math.max(0, k - n + 1); x1 < Math.min(k + 1, n); x1++) {
                int y1 = k - x1;
                if (grid[x1][y1] == -1) {
                    continue;
                }
                for (int x2 = Math.max(0, k - n + 1); x2 < Math.min(k + 1, n); x2++) {
                    int y2 = k - x2;
                    if (grid[x2][y2] == -1) {
                        continue;
                    }
                    int res = dp[k - 1][x1][x2]; // 两人同时 向右移动
                    if (x1 > 0) {
                        res = Math.max(res, dp[k - 1][x1 - 1][x2]); // 向下 向右
                    }
                    if (x2 > 0) {
                        res = Math.max(res, dp[k - 1][x1][x2 - 1]); // 向右 向下
                    }
                    if (x1 > 0 && x2 > 0) {
                        res = Math.max(res, dp[k - 1][x1 - 1][x2 - 1]); // 两人同时 向下移动
                    }
                    res += grid[x1][y1];
                    if (x1 != x2) {
                        res += grid[x2][y2];
                    }
                    dp[k][x1][x2] = res;
                }
            }
        }
        return dp[2 * n - 2][n - 1][n - 1];
    }

    /**
     * 将不可到达的点设置为 -1
     */
    private void check(int[][] grid) {
        int N = grid.length;
        for (int i = 1; i < N; i++) {
            if (grid[i - 1][0] == -1) {
                grid[i][0] = -1;
            }
            if (grid[0][i - 1] == -1) {
                grid[0][i] = -1;
            }
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (grid[i - 1][j] == -1 && grid[i][j - 1] == -1) {
                    grid[i][j] = -1;
                }
            }
        }
    }
}
