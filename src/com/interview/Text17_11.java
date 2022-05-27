package com.interview;

/**
 * 遍历
 */
public class Text17_11 {
    public int findClosest(String[] words, String word1, String word2) {
        int n = words.length;
        int idx1 = -1, idx2 = -1;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            String curStr = words[i];
            if (curStr.equals(word1)) {
                idx1 = i;
                if (idx2 != -1) {
                    ans = Math.min(idx1 - idx2, ans);
                }
            } else if (curStr.equals(word2)) {
                idx2 = i;
                if (idx1 != -1) {
                    ans = Math.min(idx2 - idx1, ans);
                }
            }
            if (ans == 1) {
                break;
            }
        }
        return ans;
    }
}
