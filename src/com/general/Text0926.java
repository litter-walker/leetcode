package com.general;

/**
 * 枚举：
 *  枚举 1 开始的位置
 */
public class Text0926 {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        // 表示 左边 1 的数量
        int oneCount = 0;
        // 表示右边 0 的数量
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                zeroCount++;
            }
        }
        int ans = n;
        // 开始枚举
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            ans = Math.min(ans, oneCount + zeroCount);
            if (ch == '1') {
                oneCount++;
            } else {
                zeroCount--;
            }
        }
        // 特殊情况，答案可能是全 0
        return oneCount > 0 && oneCount < ans ? oneCount : ans;
    }
}
