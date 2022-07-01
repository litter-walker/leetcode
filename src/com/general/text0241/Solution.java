package com.general.text0241;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 记忆 + 分治
 */
public class Solution {
    /**
     * 保存expression的list
     */
    private Map<String, List<Integer>> expList = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        if (expList.containsKey(expression)) {
            return expList.get(expression);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if ("+-*".indexOf(ch) >= 0) {
                List<Integer> lefts = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rights = diffWaysToCompute(expression.substring(i + 1));
                for (int left : lefts) {
                    for (int right : rights) {
                        switch (ch) {
                            case '+':
                                ans.add(left + right);
                                break;
                            case '-':
                                ans.add(left - right);
                                break;
                            case '*':
                                ans.add(left * right);
                                break;
                        }
                    }
                }
            }
        }
        if (ans.size() == 0) {
            ans.add(Integer.valueOf(expression));
        }
        expList.put(expression, ans);
        return ans;
    }
}
