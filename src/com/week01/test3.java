package com.week01;

/*
给你一个整数数组arr和一个整数difference，请你找出并返回 arr中最长等差子序列的长度，
该子序列中相邻元素之间的差等于 difference 。

子序列 是指在不改变其余元素顺序的情况下，
通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
 */

import java.util.HashMap;
import java.util.Map;

/**
 * dp算法：计算前n个数字的最长等差序列长度
 * Map<Integer, Integer> dp;
 * dp[xi] = max(dp[xi - diff] + 1, dp[xi]);
 */


public class test3 {
    public static int longestSubsequence(int[] arr, int difference) {

        int maxLength = 1;
        Map<Integer, Integer> dp = new HashMap<>();

        for (int num : arr) {
            int key = num - difference;
            int value = dp.getOrDefault(key, 0) + 1;
            value = Math.max(dp.getOrDefault(num, 0), value);
            dp.put(num, value);
            maxLength = Math.max(maxLength, value);
        }

        return maxLength;

    }

    public static void main(String[] args) {

    }
}
