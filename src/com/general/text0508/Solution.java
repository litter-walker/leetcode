package com.general.text0508;

import java.util.*;

/**
 * 深度 + 哈希表
 */
public class Solution {
    private final Map<Integer, Integer> map = new HashMap<>();
    private int maxCount = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);

        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCount) {
                ans.add(entry.getKey());
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = dfs(root.left) + dfs(root.right) + root.val;
        int count = map.getOrDefault(sum, 0) + 1;
        map.put(sum, count);
        maxCount = Math.max(maxCount, count);
        return sum;
    }
}
