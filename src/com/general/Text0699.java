package com.general;

import java.util.ArrayList;
import java.util.List;

/**
 * 官方思路：暴力枚举
 *  ans 表示：记录第 i 块方块掉落下来后，第 i 块所占区间的高度；
 *
 */
public class Text0699 {

    public List<Integer> fallingSquares(int[][] positions) {
        int n = positions.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int left = positions[i][0];
            int rigth = left + positions[i][1] - 1;
            int maxHeight = positions[i][1];
            for (int j = 0; j < i; j++) {
                int preL = positions[j][0];
                int preR = preL + positions[j][1] - 1;
                if (rigth >= preL && left <= preR) {
                    maxHeight = Math.max(maxHeight, ans.get(j) + positions[i][1]);
                }
            }
            ans.add(maxHeight);
        }
        for (int i = 1; i < n; i++) {
            ans.set(i, Math.max(ans.get(i - 1), ans.get(i)));
        }
        return ans;
    }

}
