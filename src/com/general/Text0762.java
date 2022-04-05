package com.general;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 简单模拟
 */
public class Text0762 {

    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        Collections.addAll(set, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31);
        for (int i = left; i <= right; i++) {
            if (set.contains(Integer.bitCount(i))) {
                count++;
            }
        }
        return count;
    }

}
