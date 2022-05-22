package com.general;

import java.util.HashMap;
import java.util.Map;

/**
 * DFS + 记忆
 */
public class Text0464 {

    private final Map<Integer, Boolean> map = new HashMap<>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((maxChoosableInteger + 1) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        return dfs(maxChoosableInteger, desiredTotal, 0);
    }

    private boolean dfs(int maxChoosableInteger, int desiredTotal, int curBit) {
        if (!map.containsKey(curBit)) {
            boolean res = false;
            for (int i = 0; i < maxChoosableInteger; i++) {
                if (((curBit >> i) & 1) == 0) {
                    if (desiredTotal <= i + 1) {
                        res = true;
                        break;
                    }
                    if (!dfs(maxChoosableInteger, desiredTotal - i - 1, curBit | (1 << i))) {
                        res = true;
                        break;
                    }
                }
            }
            map.put(curBit, res);
        }
        return map.get(curBit);
    }

}
