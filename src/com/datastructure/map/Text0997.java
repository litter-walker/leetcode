package com.datastructure.map;

/**
 * 模拟：
 *  临接矩阵：出入度
 */
public class Text0997 {

    public int findJudge(int n, int[][] trust) {
        int[] in = new int[n + 1];
        int[] out = new int[n + 1];
        for (int[] tru : trust) {
            out[tru[0]]++;
            in[tru[1]]++;
        }
        int ans = -1;
        for (int i = 1; i <= n; i++) {
            if (in[i] == n - 1 && out[i] == 0) {
                ans = i;
                break;
            }
        }
        return ans;
    }

}