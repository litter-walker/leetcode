package com.general;

import java.util.ArrayList;
import java.util.List;

/**
 * 字典树+深度优先搜索
 */
public class Text0386 {

    // 字典树 + 深度优先搜索
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < n; i++) {
            ans.add(num);
            if (num * 10 <= n) {
                num *= 10;
            } else {
                while (num + 1 > n || num % 10 == 9) {
                    num /= 10;
                }
                num++;
            }
        }
        return ans;
    }

}
