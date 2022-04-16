package com.general;

/**
 * 枚举
 * 关键点：使用 ans < 10 ^ (2 * n);
 * 解题思路：
 * 可以先求出 回文数 的 左半部分（left），然后得出右半部分，即可；
 * left 可以使用 暴力枚举 的方式得到
 */
public class Text0479 {

    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        int ans = 0;
        int upper = (int) Math.pow(10, n) - 1;
        // 枚举left
        for (int left = upper; ans == 0; --left) {
            long num = left;
            // 将右边的数字加上
            for (int right = left; right > 0; right /= 10) {
                num = num * 10 + right % 10;
            }
            // 遍历判断是否满足要求
            for (long x = upper; x * x > num; --x) {
                if (num % x == 0) {
                    ans = (int) (num % 1337);
                    break;
                }
            }
        }
        return ans;
    }

}
