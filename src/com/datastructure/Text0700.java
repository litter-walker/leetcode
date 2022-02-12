package com.datastructure;

import com.util.TreeNode;

/**
 * 递归
 */
public class Text0700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val < val) {
            return searchBST(root.right, val);
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return root;
        }
    }

}
