package com.algorithm.bitoperation;

/**
 * 官方题解：位运算
 */
public class Text0191 {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
}
