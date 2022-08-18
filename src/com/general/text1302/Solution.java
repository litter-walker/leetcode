package com.general.text1302;

/*
    dfs
 */
public class Solution {

    private int deepest = 0;
    private int leafSum = 0;

    public int deepestLeavesSum(TreeNode root) {
        deepest = 0;
        leafSum = 0;
        dfs(root, 0);
        return leafSum;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth == deepest) {
            leafSum += node.val;
        } else if (depth > deepest) {
            leafSum = node.val;
            deepest = depth;
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
