package com.general;

/**
 * 简单模拟
 */
public class Text1342 {

    public static int numberOfSteps(int num) {
        int step = 0;
        while (num != 0) {
            num = num % 2 == 1 ? num - 1 : num / 2;
            step++;
        }
        return step;
    }

    public static void main(String[] args) {
        int num = 14;
        System.out.println("num = " + num);
        System.out.println("numberOfSteps(num) = " + numberOfSteps(num));
    }
}
