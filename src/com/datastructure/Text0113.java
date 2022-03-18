package com.datastructure;

import com.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * DFS
 */
public class Text0113 {

    private final List<List<Integer>> ansList = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> sumList = new ArrayList<>(){{add(root.val);}};
        dfs(root.left, targetSum - root.val, sumList);
        dfs(root.right, targetSum - root.val, sumList);
        if (root.left == null && root.right == null && root.val == targetSum) {
            ansList.add(sumList);
        }
        return ansList;
    }

    private void dfs(TreeNode node, int targetSum, List<Integer> sumList) {
        if (node == null) {
            return;
        }
        List<Integer> newSumList = new ArrayList<>(sumList){{add(node.val);}};
        if (targetSum == node.val && node.left == null && node.right == null) {
            ansList.add(newSumList);
            return;
        }
        dfs(node.left, targetSum - node.val, newSumList);
        dfs(node.right, targetSum - node.val, newSumList);
    }


}
