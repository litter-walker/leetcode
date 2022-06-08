package com.general;

/**
 * 斜率关系
 * 官方题解更优：
 *  直接叉乘
 *  计算的等式一样，但使用官方题解的思路，可以减少相同点的判断
 */
public class Text1037 {
    public boolean isBoomerang(int[][] points) {
        int x1 = points[0][0], y1 = points[0][1];
        int x2 = points[1][0], y2 = points[1][1];
        int x3 = points[2][0], y3 = points[2][1];

        int hash1 = x1 * 100 + y1;
        int hash2 = x2 * 100 + y2;
        int hash3 = x3 * 100 + y3;
        // 判断是否有相同的点
        if (hash1 == hash2 || hash1 == hash3 || hash2 == hash3) {
            return false;
        }
        // 判断斜率是否相同（将除法，改为乘法的形式）
        return (y1 - y2) * (x1 - x3) != (y1 - y3) * (x1 - x2);
    }
}
