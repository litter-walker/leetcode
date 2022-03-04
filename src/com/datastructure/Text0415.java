package com.datastructure;

/**
 * 模拟计算
 */
public class Text0415 {

    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) {
            return addStrings(num2, num1);
        }
        StringBuilder ans = new StringBuilder();
        // 记录进位
        int prev = 0;
        int r1 = num1.length() - 1, r2 = num2.length() - 1;
        while (r1 >= 0) {
            int cur = num1.charAt(r1--) - '0';
            if (prev != 0) {
                cur += prev;
            }
            if (r2 >= 0) {
                cur += num2.charAt(r2--) - '0';
            }
            ans.append(cur % 10);
            prev = cur / 10;
        }
        if (prev != 0) {
            ans.append(prev);
        }
        return ans.reverse().toString();
    }

}
