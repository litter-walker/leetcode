package com.algorithm.firstsearch;

/**
 * DFS
 */
public class Text0695 {

    private int[][] grid;
    private static final int[] dirs = {-1, 0, 1, 0, -1};
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                ans = Math.max(ans, DFS(i, j));
            }
        }
        return ans;
    }

    private int DFS(int x, int y) {
        if (grid[x][y] == 0) {
            return 0;
        }
        int count = grid[x][y];
        grid[x][y] = 0;
        for (int i = 1; i < dirs.length; i++) {
            int nextX = x + dirs[i - 1], nextY = y + dirs[i];
            if (nextX >= 0 && nextX < grid.length &&
                    nextY >= 0 && nextY < grid[nextX].length) {
                count += DFS(nextX, nextY);
            }
        }
        return count;
    }
}
