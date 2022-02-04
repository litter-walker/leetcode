package com.datastructure;

import java.util.*;

/**
 *
 */
public class Text0073 {

    public static void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (Integer row : rows) {
            Arrays.fill(matrix[row], 0);
        }
        for (Integer col : cols) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        System.out.println("matrix = " + Arrays.deepToString(matrix));
        setZeroes(matrix);
        System.out.println("matrix = " + Arrays.deepToString(matrix));
    }

}
