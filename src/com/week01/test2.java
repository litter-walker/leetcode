package com.week01;

import java.util.PriorityQueue;

public class test2 {

    public static int trapRainWater(int[][] heightMap) {

        // 特殊情况（m 或 n小于3 ）
        int m = heightMap.length;
        int n = heightMap[0].length;
        if(m < 3 || n < 3) {
            return 0;
        }

        // 获取边界，记录访问
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    pq.offer(new int[]{i, j, heightMap[i][j]});
                    visited[i][j] = true;
                }

            }
        }

        // 缩小边界
        int res = 0; // 接收结果
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();

            // 上下左右，遍历查找，并入队
            int[] position = new int[]{-1, 0, 1, 0, -1};
            for(int i = 0; i < 4; i++) {
                int xn = cur[0] + position[i];
                int yn = cur[1] + position[i + 1];
                if(xn >= 0 && yn >= 0 && xn < m && yn < n && !visited[xn][yn]) {
                    int temp = cur[2] - heightMap[xn][yn];
                    if(temp >= 0) {
                        res += temp;
                    }
                    pq.offer(new int[]{xn, yn, Math.max(heightMap[xn][yn], cur[2])});
                    visited[xn][yn] = true;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {

        int[][] heightMap = new int[][]{{3,3,3,3,3},
                                        {3,2,2,2,3},
                                        {3,2,1,2,3},
                                        {3,2,2,2,3},
                                        {3,3,3,3,3}};
        trapRainWater(heightMap);
    }

}
