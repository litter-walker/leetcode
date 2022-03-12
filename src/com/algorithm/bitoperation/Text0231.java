package com.algorithm.bitoperation;

/**
 * 位运算
 */
public class Text0231 {

    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        return (n & n - 1) == 0;
    }

}
