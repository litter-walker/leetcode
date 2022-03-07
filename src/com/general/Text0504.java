package com.general;

/**
 * 模拟：除K取余法
 */
public class Text0504 {
    public String convertToBase7(int num) {
        if (num < 0) {
            return "-" + convertToBase7(-num);
        }
        StringBuilder ansSB = new StringBuilder();
        while (num >= 7) {
            ansSB.append(num % 7);
            num /= 7;
        }
        ansSB.append(num);
        return ansSB.reverse().toString();
    }

    public static void main(String[] args) {
        int num = -8;
        System.out.println("new Text0504().convertToBase7(num) = " + new Text0504().convertToBase7(num));
    }
}
