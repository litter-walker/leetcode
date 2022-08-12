package com.general.text0640;

/*
    字符串解析
 */
public class Solution {
    public String solveEquation(String equation) {
        String[] split = equation.split("=");
        int[] equationPre = countXAndSum(split[0]);
        int[] equationSuf = countXAndSum(split[1]);
        if (equationPre[0] == equationSuf[0]) {
            if (equationPre[1] == equationSuf[1]) {
                return "Infinite solutions";
            }
            return "No solution";
        }
        return "x=" + (equationSuf[1] - equationPre[1]) / (equationPre[0] - equationSuf[0]);
    }

    // 求字符串 x 的数量和常量的和
    private int[] countXAndSum(String s) {
        if (s.length() > 0 && s.charAt(0) != '-' && s.charAt(0) != '+') {
            s = "+" + s;
        }
        int[] res = new int[2];
        int start = 0;
        for (int end = 1; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (ch == 'x') {
                if (start == end - 1) {
                    if (s.charAt(start) == '-') {
                        res[0]--;
                    } else {
                        res[0]++;
                    }
                } else {
                    res[0] += Integer.parseInt(s.substring(start, end));
                }
                end++;
                start = end;
            } else if (ch == '+' || ch == '-') {
                res[1] += Integer.parseInt(s.substring(start, end));
                start = end;
            }
        }
        // 最后一组
        if (start < s.length()) {
            res[1] += Integer.parseInt(s.substring(start));
        }
        return res;
    }
}
