package com.general;

/**
 * 暴力枚举-海伦公式
 */
public class Text0812 {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    double area = clacArea(points[i], points[j], points[k]);
                    if (Double.isFinite(area) && max < area) {
                        max = area;
                    }
                }
            }
        }
        return max;
    }

    private double clacArea(int[] point1, int[] point2, int[] point3) {
        double a = clacDistance(point1, point2);
        double b = clacDistance(point1, point3);
        double c = clacDistance(point2, point3);
        double q = (a + b + c) / 2;
        double areaSq = q * (q - a) * (q - b) * (q - c);
        return Math.sqrt(areaSq);
    }

    private double clacDistance(int[] point1, int[] point2) {
        int distanceSq = (point1[0] - point2[0]) * (point1[0] - point2[0]) +
                (point1[1] - point2[1]) * (point1[1] - point2[1]);
        return Math.sqrt(distanceSq);
    }
}
