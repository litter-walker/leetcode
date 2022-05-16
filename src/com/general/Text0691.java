package com.general;

import java.util.Arrays;

/**
 * DFS + 记忆
 */
public class Text0691 {
    int N = 20, INF = 50, M = 1 << 20;
    int[] f = new int[M];
    String t;
    String[] ss;


    public int minStickers(String[] stickers, String target) {
        t = target;
        ss = stickers;
        Arrays.fill(f, -1);

        int ans = dfs(0);
        return ans == INF ? -1 : ans;
    }

    private int dfs(int stat) {
        int n = t.length();
        if (stat == (1 << n) - 1) {
            return 0;
        }
        if (f[stat] != -1) {
            return f[stat];
        }
        int ans = INF;
        for (String s : ss) {
            int newStat = stat;
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < n; j++) {
                    if ((s.charAt(i) == t.charAt(j) && ((newStat >> j) & 1) == 0)) {
                        newStat |= (1 << j);
                        break;
                    }
                }
            }
            if (newStat != stat) {
                ans = Math.min(ans, dfs(newStat) + 1);
            }
        }
        return f[stat] = ans;
    }

}
