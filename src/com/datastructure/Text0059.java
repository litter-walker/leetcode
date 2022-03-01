package com.datastructure;

/**
 * 模拟：
 *  控制转向
 */
public class Text0059 {


    public int[][] generateMatrix(int n) {
        int count = 1;
        int[] dirs = {0, 1, 0, -1, 0}; // 右下左上
        int dirIdx = 1;
        int[][] ansArrays = new int[n][n];
        int curX = 0, curY = 0;
        while (count <= n * n) {
            ansArrays[curX][curY] = count++;
            int nextX = curX + dirs[dirIdx], nextY = curY + dirs[dirIdx + 1];
            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || ansArrays[nextX][nextY] != 0) {
                dirIdx = (dirIdx + 1) % 4;
            }
            curX = curX + dirs[dirIdx];
            curY = curY + dirs[dirIdx + 1];
        }
        return ansArrays;
    }

}
