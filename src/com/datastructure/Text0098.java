package com.datastructure;

import com.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历
 */
public class Text0098 {

    private final List<Integer> values = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        inorderTraversal(root);
        for (int i = 1; i < values.size(); i++) {
            if (values.get(i) <= values.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        values.add(root.val);
        inorderTraversal(root.right);
    }





}
