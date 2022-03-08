package com.algorithm.firstsearch;

import java.util.Deque;
import java.util.LinkedList;

/**
 * BFS
 */
public class Text0994 {
    private static final int[] dirs = {-1, 0, 1, 0, -1};

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        Deque<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int[][] days = new int[m][n];
        int goodCount = 0;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (grid[x][y] == 2) {
                    que.offer(new int[]{x, y});
                    visited[x][y] = true;
                } else if (grid[x][y] == 1) {
                    goodCount++;
                }
            }
        }
        int ans = 0;
        while (!que.isEmpty()) {
            int[] poll = que.poll();
            for (int i = 1; i < dirs.length; i++) {
                int nextX = poll[0] + dirs[i - 1], nextY = poll[1] + dirs[i];
                if (nextX >= 0 && nextX < m &&
                        nextY >= 0 && nextY < n &&
                        !visited[nextX][nextY] &&
                        grid[nextX][nextY] == 1) {
                    days[nextX][nextY] = days[poll[0]][poll[1]] + 1;
                    que.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                    goodCount--;
                        ans = Math.max(days[nextX][nextY], ans);
                }
            }
        }
        if (goodCount > 0) {
            ans = -1;
        }
        return ans;
    }

}
