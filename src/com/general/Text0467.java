package com.general;

import java.util.Arrays;

/**
 * 动态规划
 *  使用 dp[i] 表示 以 i 结尾的子串最长的长度；就代表了以 i 结尾的 唯一 子串数量
 *  那么最后的结果就为 dp 之和；
 */
public class Text0467 {
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int k = 0;
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            if (i > 0 && (p.charAt(i - 1) - 'a' + 1) % 26 == ch - 'a') {
                k++;
            } else {
                k =  1;
            }
            dp[ch - 'a'] = Math.max(dp[ch - 'a'], k);
        }
        return Arrays.stream(dp).sum();
    }
}
