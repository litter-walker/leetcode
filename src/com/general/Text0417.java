package com.general;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Text0417 {
    private static final int[] dirs = {-1, 0, 1, 0, -1};
    private int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        int m = heights.length, n = heights[0].length;
        boolean[][] isPac = new boolean[m][n];
        boolean[][] isAtl = new boolean[m][n];

        for (int i = 0; i < n; i++) {
            DFS(0, i, isPac);
            DFS(m - 1, i, isAtl);
        }

        for (int i = 0; i < m; i++) {
            DFS(i, 0, isPac);
            DFS(i, n - 1, isAtl);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isAtl[i][j] && isPac[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    private void DFS(int x, int y, boolean[][] ocean) {
        if (ocean[x][y]) {
            return;
        }
        ocean[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = dirs[i] + x;
            int ny = dirs[i + 1] + y;
            if (nx >= 0 && nx < heights.length &&
                    ny >= 0 && ny < heights[0].length &&
                    heights[nx][ny] >= heights[x][y]) {
                DFS(nx, ny, ocean);
            }
        }
    }
}
