package com.general;

import java.util.Arrays;

/**
 *  简单模拟
 */
public class Text1672 {

    public int maximumWealth(int[][] accounts) {
        int maxAccount = 0;
        for (int[] account : accounts) {
            maxAccount = Math.max(maxAccount, Arrays.stream(account).sum());
        }
        return maxAccount;
    }

}
