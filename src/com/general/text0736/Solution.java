package com.general.text0736;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * dfs <p>
 * 参考：
 * <a href = "https://www.bilibili.com/video/BV1db41137HK?vd_source=a083aea6c56f6975cc2a911a7fcc43f5">
 * LeetCode 736. Parse Lisp Expression 中文解释 Chinese Version
 * <a/>
 */
public class Solution {
    public int evaluate(String expression) {
        return dfs(expression, new HashMap<>());
    }

    private int dfs(String expression, Map<String, Integer> var) {
        if (isNumber(expression)) {
            return Integer.parseInt(expression);
        }
        if (isVariable(expression)) {
            return var.get(expression);
        }
        List<String> exps = parse(expression);
        if (exps.get(0).equals("add")) {
            return dfs(exps.get(1), var) + dfs(exps.get(2), var);
        } else if (exps.get(0).equals("mult")) {
            return dfs(exps.get(1), var) * dfs(exps.get(2), var);
        } else {
            Map<String, Integer> curVar = new HashMap<>(var);
            for (int i = 1; i < exps.size() - 1; i += 2) {
                curVar.put(exps.get(i), dfs(exps.get(i + 1), curVar));
            }
            return dfs(exps.get(exps.size() - 1), curVar);
        }
    }

    private boolean isNumber(String expression) {
        char ch = expression.charAt(0);
        return ch >= '0' && ch <= '9' || ch == '-';
    }

    private boolean isVariable(String expression) {
        char ch = expression.charAt(0);
        return ch >= 'a' && ch <= 'z';
    }

    private List<String> parse(String expression) {
        List<String> res = new ArrayList<>();
        expression = expression.substring(1, expression.length() - 1);
        int startIdx = 0;
        while (startIdx < expression.length()) {
            int endIdx = next(expression, startIdx);
            res.add(expression.substring(startIdx, endIdx));
            startIdx = endIdx + 1;
        }
        return res;
    }

    private int next(String expression, int startIdx) {
        int endIdx = startIdx;
        if (expression.charAt(startIdx) == '(') {
            int top = 1;
            endIdx++;
            while (endIdx < expression.length() && top > 0) {
                if (expression.charAt(endIdx) == '(') {
                    top++;
                } else if (expression.charAt(endIdx) == ')') {
                    top--;
                }
                endIdx++;
            }
        } else {
            while (endIdx < expression.length() && expression.charAt(endIdx) != ' ') {
                endIdx++;
            }
        }
        return endIdx;
    }
}
