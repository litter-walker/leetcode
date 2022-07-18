package com.general.text0749;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 递归模拟
 */
public class Solution {
    private int[][] grid;
    private int m, n;
    private int[] dirs = {-1, 0, 1, 0, -1};

    public int containVirus(int[][] isInfected) {
        grid = isInfected;
        m = isInfected.length;
        n = isInfected[0].length;

        int ans = 0;
        while (true) {
            int[] point = maxDanger();
            int curNeedWalls = isolateVirus(point[0], point[1]);
            if (curNeedWalls == 0) {
                break;
            }
            ans += curNeedWalls;
            nextDay();
        }
        return ans;
    }

    private int[] maxDanger() {
        int[] res = new int[]{-1, -1};
        int maxCount = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    Set<Point> newVirus = new HashSet<>();
                    dfs(i, j, visited, newVirus);
                    int curCount = newVirus.size();
                    if (curCount > maxCount) {
                        maxCount = curCount;
                        res[0] = i;
                        res[1] = j;
                    }
                }
            }
        }
        return res;
    }

    private void dfs(int x, int y, boolean[][] visited, Set<Point> newVirus) {
        if (x < 0 || x >= m || y < 0 || y >= n
                || visited[x][y] || grid[x][y] == 2) {
            return;
        }
        if (grid[x][y] == 0) {
            newVirus.add(new Point(x, y));
            return;
        }
        visited[x][y] = true;
        for (int i = 1; i < dirs.length; i++) {
            int nextX = x + dirs[i - 1];
            int nextY = y + dirs[i];
            dfs(nextX, nextY, visited, newVirus);
        }
    }

    private void nextDay() {
        List<int[]> virus = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    virus.add(new int[]{i, j});
                }
            }
        }
        for (int[] viru : virus) {
            for (int i = 1; i < dirs.length; i++) {
                int nextX = viru[0] + dirs[i - 1];
                int nextY = viru[1] + dirs[i];
                if (nextX >= 0 && nextX < m
                        && nextY >= 0 && nextY < n
                        && grid[nextX][nextY] == 0) {
                    grid[nextX][nextY] = 1;
                }
            }
        }
    }

    private int isolateVirus(int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n
                || grid[x][y] == 2) {
            return 0;
        }
        if (grid[x][y] == 0) {
            return 1;
        }
        grid[x][y] = 2;
        int res = 0;
        for (int i = 1; i < dirs.length; i++) {
            int nextX = x + dirs[i - 1];
            int nextY = y + dirs[i];
            res += isolateVirus(nextX, nextY);
        }
        return res;
    }
}
