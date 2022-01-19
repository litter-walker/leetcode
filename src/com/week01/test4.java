package com.week01;

public class test4 {

    public static int maxCount(int m, int n, int[][] ops) {
        int min_x = m;
        int min_y = n;

        for (int[] op : ops) {
            min_x = Math.min(min_x, op[0]);
            min_y = Math.min(min_y, op[1]);
        }

        return min_x * min_y;
    }

    public static void main(String[] args) {

        int m = 3, n =3;
        int[][] ops = new int[][]{{2,2},{3,3}};

        System.out.println(maxCount(m, n, ops));
    }
}
