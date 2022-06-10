package com.general;

/**
 * 动态规划：
 *  创建一个 dp，dp[k][i][j] 表示 在[i, j]的区间中，以 k 开头的回文串数量
 *  那么，最后的回文串数量为 sum(dp[0...3][0][n-1])
 *      初始化：dp[k][i][j] 如果 k == s1 且 i == j， dp[k][i][j] = 1
 *      当 i < j 时，
 *          1. si == k == sj, dp[k][i][j] = sum(dp[0...3][i][j])
 *          2. si != k == sj, dp[k][i][j] = dp[k][i+1][j]
 *          3. si == k != sj, dp[k][i][j] = dp[k][i][j-1]
 *          4. si != k != sj, dp[k][i][j] = dp[k][i+1][j-1]
 */
public class Text0730 {
    private static final int MOD = (int)(1e9 + 7);

    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        int[][][] dp = new int[4][n][n];
        for (int i = 0; i < n; i++) {
            dp[s.charAt(i) - 'a'][i][i] = 1;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                char chL = s.charAt(i), chR = s.charAt(j);
                for (char ch = 'a'; ch <= 'd'; ch++) {
                    int k = ch - 'a';
                    if (chL == ch && chR == ch) {
                        dp[k][i][j] = (2 + (dp[0][i + 1][j - 1] + dp[1][i + 1][j - 1]) % MOD  + (dp[2][i + 1][j - 1] + dp[3][i + 1][j - 1]) % MOD) % MOD;
                    } else if (chL == ch) {
                        dp[k][i][j] = dp[k][i][j - 1];
                    } else if (chR == ch) {
                        dp[k][i][j] = dp[k][i + 1][j];
                    } else {
                        dp[k][i][j] = dp[k][i + 1][j - 1];
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            ans = (ans + dp[i][0][n - 1]) % MOD;
        }
        return ans;
    }
}
