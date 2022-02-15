package com.general;

import java.util.*;

/**
 * 关键：数字各不相同；
 * 将行最小值和列最大值列出来，找出重复的值即可
 */
public class Text1380 {


    public static List<Integer> luckyNumbers (int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int[] rowMin = new int[m];
        int[] colMax = new int[n];
        Arrays.fill(rowMin, Integer.MAX_VALUE);
        Arrays.fill(colMax, Integer.MIN_VALUE);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < rowMin[i]) {
                    rowMin[i] = matrix[i][j];
                }
                if (matrix[i][j] > colMax[j]) {
                    colMax[j] = matrix[i][j];
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        for (int row : rowMin) {
            set.add(row);
        }
        for (int col : colMax) {
            if (set.contains(col)) {
                ans.add(col);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{3,7,8},{9,11,13},{15,16,17}};
        System.out.println("matrix = " + Arrays.deepToString(matrix));
        System.out.println("luckyNumbers(matrix) = " + luckyNumbers(matrix));

    }
}
