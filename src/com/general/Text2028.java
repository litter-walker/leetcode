package com.general;

import java.util.Arrays;

/**
 * 数学：
 *  计算出丢失数据的总和：sum
 *  判断丢失数据的总和是否规范 （ n <= sum <= 6 * n ）
 *  将总和 平均分给每一个 丢失数据, 多余的数据补齐即可；
 */
public class Text2028 {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = mean * (m + n);
        for (int roll : rolls) {
            sum -= roll;
        }
        if (sum < n || sum > 6 * n) {
            return new int[0];
        }
        int[] ans = new int[n];

        Arrays.fill(ans, 0, sum % n, sum / n + 1);
        Arrays.fill(ans, sum % n, n, sum / n);
        return ans;
    }

}
