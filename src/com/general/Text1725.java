package com.general;

import java.util.Arrays;

/**
 * 遍历
 */
public class Text1725 {

    public static int countGoodRectangles(int[][] rectangles) {
        // 表示长方形可切成的正方形的最大边长以及对应的数量;
        int maxLen = 0, count = 0;
        for (int[] rectangle : rectangles) {
            int w = Math.min(rectangle[0], rectangle[1]);
            if (maxLen < w) {
                maxLen = w;
                count = 1;
            } else if (maxLen == w) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[][] rectangles = {{2,3},{3,7},{4,3},{3,7}};
        System.out.println("rectangles = " + Arrays.deepToString(rectangles));
        System.out.println("countGoodRectangles(rectangles) = " + countGoodRectangles(rectangles));
    }

}
