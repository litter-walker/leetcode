package com.general.text1422;

/*
    前缀和
 */
public class Solution {
    public int maxScore(String s) {
        int n = s.length();

        // 初始化
        int rightOne = 0, leftZero = s.charAt(0) == '0' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '1') {
                rightOne++;
            }
        }
        int sum = rightOne + leftZero;
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == '1') {
                rightOne--;
            } else {
                leftZero++;
            }
            sum = Math.max(sum, rightOne + leftZero);
        }
        return sum;
    }
}
