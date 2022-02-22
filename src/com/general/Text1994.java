package com.general;

import java.util.Arrays;

/**
 * 解题关键： 1 <= nums[i] <= 30
 *  使用DP进行解题
 *  可以将DP进行压缩减少空间的使用
 */
public class Text1994 {

    private static final int[] PRIME_NUMBER = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    private static final int ANS_MOD = (int) (1e9 + 7);
    private static final int MAX_NUM = 30;

    public int numberOfGoodSubsets(int[] nums) {
        // 记录每个数字的数量
        int[] counts = new int[MAX_NUM + 1];
        for (int num : nums) {
            counts[num]++;
        }
        // 保存dp的每层的信息, 初始化为 dp[0] = 1 (即，一个不选时为1，便于单个选项时使用);
        int[] dp = new int[1 << PRIME_NUMBER.length];
        dp[0] = 1;
        // 遍历【2-30】的数
        for (int i = 2; i <= MAX_NUM; i++) {
            // 如果 i 不存在，就计算下一个
            if (counts[i] == 0) {
                continue;
            }
            // 判断 i 是否存在 平方因子;
            // 如果存在，则跳过 i
            // 如果不存在，则使用 10位 的二进制表示 i 的质因子
            boolean existSquare = false;
            int curPrimeFactor = 0;
            for (int j = 0; j < PRIME_NUMBER.length; j++) {
                int p = PRIME_NUMBER[j];
                if (i % (p * p) == 0) {
                    existSquare = true;
                    break;
                }
                if (i % p == 0) {
                    curPrimeFactor |= 1 << j;
                }
            }
            if (existSquare) {
                continue;
            }
            // 动态规划
            for (int prePrimeFactor = (1 << PRIME_NUMBER.length) - 1; prePrimeFactor >= 0; prePrimeFactor--) {
                // 判断 前一个因子(prePrimeFactor) 与 当前 i 的因子(curPrimeFactor)有冲突的: (prePrimeFactor & curPrimeFactor)
                // 如果有, 则不能与 i 组合成为一个集合，那么就跳过该(prePrimeFactor)
                // 如果没有, 则能与 i 组合成为一个集合, 那么就计算组合后的质因子(prePrimeFactor | curPrimeFactor) 的值
                if ((prePrimeFactor & curPrimeFactor) == 0) {
                    dp[prePrimeFactor | curPrimeFactor] = (int) ((dp[prePrimeFactor | curPrimeFactor] + (long)(dp[prePrimeFactor]) * counts[i] % ANS_MOD) % ANS_MOD);
                }
            }
        }
        int ans = 0;
        // 求得未计算1的集合数量
        for (int i = 1; i < dp.length; i++) {
            ans = (ans + dp[i]) % ANS_MOD;
        }
        // 将 1 加入集合后的数量计算
        for (int i = 0; i < counts[1]; i++) {
            ans = (ans << 1) % ANS_MOD;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,3,15};
        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("new Text1994().numberOfGoodSubsets(nums) = " + new Text1994().numberOfGoodSubsets(nums));
    }

}
