package com.datastructure;

import java.util.Arrays;

/**
 * 简单模拟
 */
public class Text0566 {

    public static int[][] matrixReshape(int[][] mat, int r, int c) {

        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] ansArray = new int[r][c];
        for (int i = 0; i < m * n; i++) {
            ansArray[i / c][i % c] = mat[i / n][i % n];
        }
        return ansArray;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2},{3,4}};
        int r = 2, c = 4;
        System.out.println("mat = " + Arrays.deepToString(mat));
        System.out.println("r = " + r);
        System.out.println("c = " + c);
        System.out.println("matrixReshape(mat, r, c) = " + Arrays.deepToString(matrixReshape(mat, r, c)));
    }
}
