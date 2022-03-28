package com.general;

/**
 * 1. 模拟
 * 2. 位运算
 */
public class Text0693 {
    // 模拟
    public boolean hasAlternatingBits(int n) {
        int pre = n & 1;
        n = n >> 1;
        while (n > 0) {
            int cur = n & 1;
            if (cur == pre) {
                return false;
            }
            pre = cur;
            n = n >> 1;
        }
        return true;
    }
    // 位运算
    public boolean hasAlternatingBits1(int n) {
        int temp = n ^ (n >> 1);
        return (temp & (temp + 1)) == 0;
    }
}
