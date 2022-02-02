package com.datastructure;

import java.util.Arrays;

/**
 * 保存当前情况下的最小价格;
 */
public class Text0121 {

    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int curMinPrice = prices[0];
        int curMaxProfit = 0;
        for (int price : prices) {
            curMaxProfit = Math.max(curMaxProfit, price - curMinPrice);
            curMinPrice = Math.min(curMinPrice, price);
        }
        return curMaxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {2, 1};
        System.out.println("prices = " + Arrays.toString(prices));
        System.out.println("maxProfit(prices) = " + maxProfit(prices));
    }

}
