package com.general;

/**
 * 简单模拟
 *
 * 进阶做法：前缀和
 */
public class Text0661 {

    private final int[] dirs = new int[]{-1, 0, 1, 0, -1, 1, 1, -1, -1};

    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] ansImg = new int[m][n];
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                int count = 1;
                int sumImg = img[x][y];
                for (int next = 1; next < dirs.length; next++) {
                    int nx = x + dirs[next - 1], ny = y + dirs[next];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        sumImg += img[nx][ny];
                        count++;
                    }
                    ansImg[x][y] = sumImg / count;
                }
            }
        }
        return ansImg;
    }

}
