package com.datastructure;

/**
 * 动态规划
 *
 * @see <a href="https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/solution/dong-tai-gui-hua-li-jie-liao-hao-yi-hui-8qlag/">参考</a>
 */
public class Text1823 {

    public int findTheWinner(int n, int k) {
        int dp = 0;
        for (int i = 2; i <= n; i++) {
            dp = (dp + k) % i;
        }
        return dp + 1;
    }

}
