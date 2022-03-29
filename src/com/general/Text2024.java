package com.general;

/**
 * 滑动窗口
 */
public class Text2024 {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxConsecutiveAnswers(answerKey, k, 'T'), maxConsecutiveAnswers(answerKey, k, 'F'));
    }

    private int maxConsecutiveAnswers(String answerKey, int k, char op) {
        int maxAns = 0;
        int l = 0, r = 0;
        while (r < answerKey.length()) {
            while (r < answerKey.length() && k >= 0) {
                if (answerKey.charAt(r) != op) {
                    k--;
                }
                r++;
            }
            if (k == -1) {
                k = 0;
                r--;
            }
            maxAns = Math.max(maxAns, r - l);
            while (l < r && k == 0) {
                if (answerKey.charAt(l) != op) {
                    k++;
                }
                l++;
            }
        }
        return maxAns;
    }

}
