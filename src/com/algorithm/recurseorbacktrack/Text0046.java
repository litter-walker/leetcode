package com.algorithm.recurseorbacktrack;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Text0046 {

    private final List<List<Integer>> ans = new ArrayList<>();
    private int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        dfs(nums.length - 1);
        return ans;
    }

    /**
     * 表示将 第 n 个数字加入后的全排列
     * @param n 数字下标
     */
    private void dfs(int n) {
        if (n == 0) {
            ans.add(new ArrayList<>(){{add(nums[0]);}});
            return;
        }
        dfs(n - 1);
        List<List<Integer>> newAddList = new ArrayList<>();
        for (List<Integer> list : ans) {
            for (int i = 0; i < list.size(); i++) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(i, nums[n]);
                newAddList.add(newList);
            }
            list.add(nums[n]);
        }
        ans.addAll(newAddList);
    }

}
