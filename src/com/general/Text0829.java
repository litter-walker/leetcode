package com.general;

/**
 * 题目：给定一个正整数 n，返回 连续正整数满足所有数字之和为 n 的组数                                     <br\>
 *  假设：以 a 开头 k 的连续数字的和为 n；其中 a >= 1, k >= 1                                        <br\>
 *  推理如下：                                                                                   <br\>
 *      => 等差公式可得：(a + (a + k - 1)) * k / 2 = n                                            <br\>
 *      => 2a = 2n / k - (k - 1) >= 2； 可知条件 1： 当 (2n / k - (k - 1)) % 2 == 0 时， a 存在    <br\>
 *      => 2n / k = 2a + k - 1; 可知 条件 2： 2n % k == 0                                        <br\>
 *      => 2n / k >= k + 1                                                                      <br\>
 *      => 2n / k > k                                                                           <br\>
 *      => 2n > k * k， 可知 条件 3： k 是，2n 公约数中较小的那一个                                   <br\>
 *
 *   <a href="https://leetcode.cn/problems/consecutive-numbers-sum/solution/by-ac_oier-220q/">
 *       参考链接：【宫水三叶】数论运用题
 *   </a>
 */
public class Text0829 {
    public int consecutiveNumbersSum(int n) {
        int ans = 0;
        n *= 2;
        for (int k = 1; k * k < n; k++) {
            if (n % k == 0 && (n / k - k + 1) % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
