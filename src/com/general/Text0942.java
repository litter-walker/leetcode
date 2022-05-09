package com.general;

/**
 * 贪心
 */
public class Text0942 {

    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] ans = new int[n + 1];
        int max = n, min = 0;
        for (int i = 0; i < n; i++) {
            // 为 'I' 时, 前面的数字填写(可以填写的)最小值, 可以保证后面的永远大于前面的
            // 为 'D' 时, 前面的数字填写(可以填写的)最大值, 可以保证后面的永远小于前面的
            if (s.charAt(i) == 'I') {
                ans[i] = min;
                min++;
            } else {
                ans[i] = max;
                max--;
            }
        }
        // 最后 0 ~ n, 之间的数字只剩下一个 ans[n] == max == min
        ans[n] = max;
        return ans;
    }

}
