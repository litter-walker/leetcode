package com.general;

import java.util.ArrayList;
import java.util.List;

/**
 * 辗转相除法
 */
public class Text1447 {

    public List<String> simplifiedFractions(int n) {
        List<String> ansList = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            ansList.add("1/" + i);
            for (int j = 2; j < i; j++) {
                if (gcd(i, j) == 1) {
                    ansList.add(j + "/" + i);
                }
            }
        }
        return ansList;
    }

    /**
     * 辗转相除法
     * @param a 除数
     * @param b 余数
     * @return 最大公约数
     */
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Text1447 text1447 = new Text1447();
        int n = 2;
        System.out.println("n = " + n);
        System.out.println("simplifiedFractions(n) = " + text1447.simplifiedFractions(n));
    }
}
