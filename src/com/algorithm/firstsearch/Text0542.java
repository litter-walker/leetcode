package com.algorithm.firstsearch;

import java.util.Deque;
import java.util.LinkedList;

/**
 * BFS
 */
public class Text0542 {

    private static final int[] dirs = {-1, 0, 1, 0, -1};

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        Deque<int[]> que = new LinkedList<>();
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (mat[x][y] == 0) {
                    que.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        while (!que.isEmpty()) {
            int[] poll = que.poll();
            for (int i = 1; i < dirs.length; i++) {
                int nextX = poll[0] + dirs[i - 1];
                int nextY = poll[1] + dirs[i];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY]) {
                    mat[nextX][nextY] = mat[poll[0]][poll[1]] + 1;
                    que.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }
        return mat;
    }

}
