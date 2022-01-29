package com.general;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Text1765 {

    public static int[][] highestPeak(int[][] isWater) {

        int n = isWater.length;
        int m = isWater[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    visited[i][j] = true;
                    isWater[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else {
                    isWater[i][j] = 1;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int[] nextStep = {-1, 0, 1, 0, -1};
            for (int i = 1; i < nextStep.length; i++) {
                int x = poll[0] + nextStep[i - 1];
                int y = poll[1] + nextStep[i];
                if (x >= n || x < 0 || y >= m || y < 0 || visited[x][y]) {
                    continue;
                }
                isWater[x][y] = isWater[poll[0]][poll[1]] + 1;
                queue.offer(new int[]{x, y});
                visited[x][y] = true;
            }
        }
        return isWater;
    }

    public static void main(String[] args) {
        int[][] isWater = {{0,0,1},{1,0,0},{0,0,0}};
        System.out.println("isWater = " + Arrays.deepToString(isWater));
        System.out.println("highestPeak(isWater) = " + Arrays.deepToString(highestPeak(isWater)));
    }

}
