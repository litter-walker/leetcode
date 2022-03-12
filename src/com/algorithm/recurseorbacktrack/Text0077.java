package com.algorithm.recurseorbacktrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归-剪枝：遍历每一个数 选 和 不选
 */
public class Text0077 {

    private final List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, null);
        return ans;
    }

    /**
     * 递归每一种可能
     * @param n 表示 选或不选 的数字
     * @param k 表示还差 k 个数字，满足要求
     * @param list ans的子集
     */
    private void dfs(int n, int k, List<Integer> list) {
        // k == 0 或者 k >= n 时，都不能满足要求
        if (list == null) {
            list = new ArrayList<>();
        }
        if (k > 0 && k < n) {
            // 不选
            dfs(n - 1, k, new ArrayList<>(list));
            // 选
            list.add(n);
            k--;
            n--;
            dfs(n, k, list);
        } else if (k == n) {
            for (int i = n; i > 0; i--) {
                list.add(i);
            }
            ans.add(list);
        } else if (k == 0) {
            ans.add(list);
        }
    }

}
