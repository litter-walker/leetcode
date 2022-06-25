package com.offer;

/**
 * DP
 */
public class Text0091 {
    public int minCost(int[][] costs) {
        int[] dp = new int[3];
        for (int[] cost : costs) {
            int[] newDp = new int[3];
            newDp[0] = Math.min(dp[1], dp[2]) + cost[0];
            newDp[1] = Math.min(dp[0], dp[2]) + cost[1];
            newDp[2] = Math.min(dp[0], dp[1]) + cost[2];
            dp = newDp;
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}
