package com.general;

import java.util.Arrays;

/**
 * 暴力枚举:
 *  枚举每一根火柴放入每一边上的可能，判断是否可以全部放入
 */
public class Text0473 {

    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        int[] edges = new int[4];
        return dfs(matchsticks.length - 1, matchsticks, edges, sum / 4);
    }

    private boolean dfs(int index, int[] matchsticks, int[] edges, int len) {
        if (index == -1) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            edges[i] += matchsticks[index];
            if (edges[i] <= len && dfs(index - 1, matchsticks, edges, len)) {
                return true;
            }
            edges[i] += matchsticks[index];
        }
        return false;
    }

}
