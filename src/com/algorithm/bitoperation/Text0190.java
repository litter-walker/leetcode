package com.algorithm.bitoperation;

/**
 * 位运算
 */
public class Text0190 {

    public int reverseBits(int n) {
        int bitCount = 32;
        int[] bits = new int[bitCount];
        for (int i = 0; i < bitCount; i++) {
            bits[i] = (n >> i) & 1;
        }
        int ans = 0;
        if (bits[0] == 1) {
            ans = Integer.MIN_VALUE;
        }
        for (int i = 1; i < bitCount; i++) {
            ans |= bits[i] << (bitCount - i - 1);
        }
        return ans;
    }

}
