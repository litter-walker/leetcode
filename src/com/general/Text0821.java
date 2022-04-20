package com.general;

import java.util.Arrays;

/**
 * 正序+逆序遍历
 */
public class Text0821 {

    public int[] shortestToChar(String s, char c) {
        int n = s. length();
        int[] answer = new int[n];
        Arrays.fill(answer, n - 1);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                answer[i] = 0;
            }
        }
        for (int i = 1; i < n; i++) {
            answer[i] = Math.min(answer[i], answer[i - 1] + 1);
        }
        for (int i = n - 2; i >= 0; i--) {
            answer[i] = Math.min(answer[i], answer[i + 1] + 1);
        }
        return answer;
    }

}
