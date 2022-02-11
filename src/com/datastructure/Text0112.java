package com.datastructure;

import com.util.TreeNode;

/**
 * 递归
 */
public class Text0112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return (root.left == null && root.right == null && targetSum == root.val) ||
                hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }
}
