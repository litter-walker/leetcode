package com.general;

/**
 * 数学+模拟
 */
public class Text0883 {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int maxXZ = 0, maxYZ = 0;
            for (int j = 0; j < n; j++) {
                ans += grid[i][j] > 0 ? 1 : 0;
                maxXZ = Math.max(maxXZ, grid[i][j]);
                maxYZ = Math.max(maxYZ, grid[j][i]);
            }
            ans += maxXZ + maxYZ;
        }
        return ans;
    }
}
