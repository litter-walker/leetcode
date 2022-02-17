package com.general;

/**
 * 递归: 需要记忆，否则会超时
 *
 * 使用DP可以解决
 */
public class Text0688 {

    // 可以使用相邻两个数字表示八个方向的移动
    private final int[] dirs = {-2, 1, 2, -1, -2, -1, 2, 1, -2};

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k + 1][n][n];
        for (int i = 0; i <= k; i++) {
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (i == 0) {
                        dp[i][x][y] = 1;
                    } else {
                        for (int j = 1; j < dirs.length; j++) {
                            int preX = x + dirs[j - 1], preY = y + dirs[j];
                            if (preX >= 0 && preX < n && preY >= 0 && preY < n) {
                                dp[i][x][y] += dp[i - 1][preX][preY] / 8;
                            }
                        }
                    }
                }
            }
        }
        return dp[k][row][column];
    }


    public static void main(String[] args) {
        int n = 3, k = 2, row = 0, column = 0;
        Text0688 text0688 = new Text0688();
        System.out.println("text0688.knightProbability(n, k, row, column) = " + text0688.knightProbability(n, k, row, column));

    }
}
