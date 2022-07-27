package com.general.text0592;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟
 */
public class Solution {
    public String fractionAddition(String expression) {
        List<String> fractionList = splitFraction(expression);
        int[] ansFraction = changeFraction(fractionList.get(0));
        for (int i = 1; i < fractionList.size(); i++) {
            String fractionStr = fractionList.get(i);
            int[] curFraction = changeFraction(fractionStr);
            // add 操作
            ansFraction[0] = ansFraction[0] * curFraction[1] + curFraction[0] * ansFraction[1];
            ansFraction[1] = ansFraction[1] * curFraction[1];
            ansFraction = simplify(ansFraction);
        }
        return ansFraction[0] + "/" + ansFraction[1];
    }

    private List<String> splitFraction(String expression) {
        List<String> res = new ArrayList<>();
        int start = 0;
        for (int i = 1; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-') {
                res.add(expression.substring(start, i));
                start = i;
            }
        }
        res.add(expression.substring(start));
        return res;
    }

    private int[] changeFraction(String fractionStr) {
        String[] fraction = fractionStr.split("/");
        return new int[]{Integer.parseInt(fraction[0]), Integer.parseInt(fraction[1])};
    }

    private int[] simplify(int[] fraction) {
        int maxGcd = gcd(fraction[0], fraction[1]);
        maxGcd = Math.abs(maxGcd);
        return new int[]{fraction[0] / maxGcd, fraction[1] / maxGcd};
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
