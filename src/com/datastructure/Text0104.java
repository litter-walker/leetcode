package com.datastructure;

import com.util.TreeNode;

/**
 * 递归
 */
public class Text0104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {

    }

}
