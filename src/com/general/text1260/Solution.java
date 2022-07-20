package com.general.text1260;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟
 */
public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                cur.add(0);
            }
            ans.add(cur);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = (i * n + j + k) % (m * n);
                ans.get(idx / n).set(idx % n, grid[i][j]);
            }
        }
        return ans;
    }
}
