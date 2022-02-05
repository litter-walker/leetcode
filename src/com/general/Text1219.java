package com.general;

import java.util.Arrays;

/**
 * DFS
 */
public class Text1219 {

    private int[][] grid;
    private boolean[][] visited;

    public int getMaximumGold(int[][] grid) {
        this.grid = grid;
        int m = grid.length;
        int n = grid[0].length;
        this.visited = new boolean[m][n];
        int maximumGold = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    visited[i][j] = true;
                    maximumGold = Math.max(DFS(i, j), maximumGold);
                    visited[i][j] = false;
                }
            }
        }
        return maximumGold;
    }

    private int DFS(int x, int y) {
        int[] step = {-1, 0, 1, 0, -1};
        int maximumGold = 0;
        for (int i = 0; i < 4; i++) {
            int nextX = x + step[i];
            int nextY = y + step[i + 1];
            if (nextX >= grid.length || nextX < 0 ||
                    nextY < 0 || nextY >= grid[0].length) {
                continue;
            }
            if (!visited[nextX][nextY] && grid[nextX][nextY] != 0) {
                visited[nextX][nextY] = true;
                maximumGold = Math.max(DFS(nextX, nextY), maximumGold);
                visited[nextX][nextY] = false;
            }
        }
        return maximumGold + grid[x][y];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}};
        System.out.println("grid = " + Arrays.deepToString(grid));
        Text1219 text1219 = new Text1219();
        System.out.println("text1219.getMaximumGold(grid) = " + text1219.getMaximumGold(grid));
    }

}
