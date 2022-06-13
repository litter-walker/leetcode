package com.general;

/**
 * 排序/计数排序
 */
public class Text1051 {
    //直接排序
//    public int heightChecker(int[] heights) {
//        int n = heights.length;
//        int[] exp = Arrays.copyOf(heights, n);
//        Arrays.sort(exp);
//        int diffCount = 0;
//        for (int i = 0; i < n; i++) {
//            if (heights[i] != exp[i]) {
//                diffCount++;
//            }
//        }
//        return diffCount;
//    }

    // 计数排序
    public int heightChecker(int[] heights) {
        int[] exp = new int[101];
        for (int height : heights) {
            exp[height]++;
        }
        int diffCount = 0;
        for (int i = 0, j = 0; i < exp.length; i++) {
            while (exp[i] > 0) {
                if (i != heights[j]) {
                    diffCount++;
                }
                j++;
                exp[i]--;
            }
        }
        return diffCount;
    }

}
