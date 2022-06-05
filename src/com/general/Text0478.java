package com.general;

import java.util.Random;

/**
 * 官方题解：
 *  拒绝采样
 */
public class Text0478 {

    Random random;
    double x, y, r;
//    public Solution(double radius, double x_center, double y_center) {
//        r = radius;
//        x = x_center;
//        y = y_center;
//        random = new Random();
//    }

    public double[] randPoint() {
        while (true) {
            double x = random.nextDouble() * (2 * r) - r;
            double y = random.nextDouble() * (2 * r) - r;
            if (x * x + y * y <= r * r) {
                return new double[]{this.x + x, this.y + y};
            }
        }
    }

}
