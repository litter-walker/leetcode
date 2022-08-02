package com.general.text1374;

/*
    简单模拟
 */
public class Solution {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 1) {
            for (int i = 0; i < n; i++) {
                sb.append('a');
            }
        } else {
            sb.append('b');
            for (int i = 1; i < n; i++) {
                sb.append('a');
            }
        }
        return sb.toString();
    }
}