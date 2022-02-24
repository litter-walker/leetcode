package com.general;

/**
 * 模拟:
 *  使用双循环进行模拟：
 *      外循环：每列开始；
 *      内循环：每列的模拟过程；
 *  设置一个 preTowards 表示小球上一次移动的方向；
 *      -1：从左至右；
 *      0：从上至下
 *      1：从右至左
 */
public class Text1706 {

    public int[] findBall(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int preTowards = 0;
            int col = i;
            int row = 0;
            while (col >= 0 && col < n) {
                if (row == m) {
                    answer[i] = col;
                    break;
                }
                if (grid[row][col] == 1) {
                    if (preTowards == 0) {
                        preTowards = 1;
                        col++;
                    } else if (preTowards == 1) {
                        preTowards = 0;
                        row++;
                    } else {
                        answer[i] = -1;
                        break;
                    }
                } else if (grid[row][col] == -1) {
                    if (preTowards == 0) {
                        preTowards = -1;
                        col--;
                    } else if (preTowards == -1) {
                        preTowards = 0;
                        row++;
                    } else {
                        answer[i] = -1;
                        break;
                    }
                }
            }
            if (col < 0 || col >= n) {
                answer[i] = -1;
            }
        }
        return answer;
    }

}
