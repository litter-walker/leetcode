package com.general;

import java.util.Random;

/**
 * 随机抽样
 *  将全部的点都加起来，随机抽取点
 */
public class Text0497 {
    private class Solution {

        private final int[][] rects;
        private final int countPoint;
        private final Random random;

        public Solution(int[][] rects) {
            this.rects = rects;
            random = new Random();
            int count = 0;
            for (int[] rect : rects) {
                count += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            }
            countPoint = count;
        }

        public int[] pick() {
            int point = random.nextInt(countPoint) + 1;
            for (int[] rect : rects) {
                int countRow = rect[3] - rect[1] + 1, countCol = rect[2] - rect[0] + 1;
                int cutCount = countCol * countRow;
                if (point - cutCount <= 0) {
                    return new int[]{rect[0] + (point - 1) % countCol, rect[1] + (point - 1) / countCol};
                }
                point -= cutCount;
            }
            throw new RuntimeException("没有找到点");
        }
    }
}
