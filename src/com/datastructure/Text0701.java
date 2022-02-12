package com.datastructure;

import com.util.TreeNode;

/**
 * 模拟迭代
 */
public class Text0701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode treeNode = new TreeNode(val);
        if (root == null) {
            return treeNode;
        }
        TreeNode node = root;
        while (node != null) {
            if (node.val > val && node.left == null) {
                node.left = treeNode;
                break;
            } else if (node.val < val && node.right == null) {
                node.right = treeNode;
                break;
            }
            node = node.val < val ? node.right : node.left;
        }
        return root;
    }

}
