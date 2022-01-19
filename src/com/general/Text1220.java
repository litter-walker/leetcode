package com.general;

import java.util.Arrays;

public class Text1220 {

    private static long MAX_NUM = (long) (1e9 + 7);

    public static int countVowelPermutation(int n) {

        // 表示字母为a,e,i,o,u当前的数量
        long[] curNum = new long[]{1, 1, 1, 1, 1};
        // 表示下一个为(a,e,i,o,u)的数量
        long[] nextNum = new long[5];
        // 表示下一个为(a,e,i,o.u)需要前一个的权重；
        // 例如：w[i][j] 表示下一个为i，上一个为j，判断是否需要加上j的数量
        int[][] w = new int[][]{
                {0, 1, 1, 0, 1},
                {1, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 1, 0},
        };
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                nextNum[j] = (
                        curNum[0] * w[j][0] +
                        curNum[1] * w[j][1] +
                        curNum[2] * w[j][2] +
                        curNum[3] * w[j][3] +
                        curNum[4] * w[j][4]
                ) % MAX_NUM;
            }
            System.arraycopy(nextNum, 0, curNum, 0, 5);
        }
        return (int) (Arrays.stream(curNum).sum() % MAX_NUM);
    }

    public static void main(String[] args) {
        int n = 10000;
        System.out.println("n = " + n);
        System.out.println("countVowelPermutation(n) = " + countVowelPermutation(n));
    }
}
