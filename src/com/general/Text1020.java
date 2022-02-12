package com.general;

import java.util.Arrays;

/**
 * 正难反易-DFS: 将不是飞地的地全部置为 0，剩下的 1 就是飞地
 */
public class Text1020 {

    private int[][] grid;
    private final int[] dirs = {-1, 0, 1, 0, -1};

    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (m == 1 || n == 1) {
            return 0;
        }
        this.grid = grid;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                DFS(i, 0);
            }
            if (grid[i][n - 1] == 1) {
                DFS(i, n - 1);
            }
        }
        for (int i = 1; i < n; i++) {
            if (grid[0][i] == 1) {
                DFS(0, i);
            }
            if (grid[m - 1][i] == 1) {
                DFS(m - 1, i);
            }
        }
        int ans = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * 使用DFS，将相邻的 陆地单元变为
     *
     * @param x 横坐标
     * @param y 纵坐标
     */
    private void DFS(int x, int y) {
        for (int i = 1; i < dirs.length; i++) {
            int nextX = x + dirs[i - 1], nextY = y + dirs[i];
            if (nextX >= 0 && nextX < grid.length &&
                    nextY >= 0 && nextY < grid[nextX].length &&
                    grid[nextX][nextY] == 1) {
                grid[nextX][nextY] = 0;
                DFS(nextX, nextY);
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
        System.out.println("grid = " + Arrays.deepToString(grid));
        System.out.println("new Text1020().numEnclaves(grid) = " + new Text1020().numEnclaves(grid));
    }

}
