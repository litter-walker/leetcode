package com.general;

/**
 *  排列组合
 */
public class Text0357 {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int count = 10, curCount = 9;
        for (int i = 0; i < n - 1; i++) {
            curCount *= 9 - i;
            count += curCount;
        }
        return count;
    }

}
