package com.algorithm.firstsearch;

import java.util.Deque;
import java.util.LinkedList;

/**
 * BFS
 */
public class Text0733 {

    private static final int[] dirs = new int[]{-1, 0, 1, 0, -1};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length, n = image[0].length;
        int oldColor = image[sr][sc];

        Deque<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;
        visited[sr][sc] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 1; i < dirs.length; i++) {
                int x = poll[0] + dirs[i - 1], y = poll[1] + dirs[i];
                if (x >= 0 && x < m &&
                        y >= 0 && y < n &&
                        image[x][y] == oldColor && !visited[x][y]) {
                    image[x][y] = newColor;
                    queue.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return image;
    }

}
