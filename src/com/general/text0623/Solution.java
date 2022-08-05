package com.general.text0623;

/*
    dfs
 */
public class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        if (depth == 1) {
            TreeNode dummyHead = new TreeNode(val);
            dummyHead.left = root;
            return dummyHead;
        }
        if (root == null) {
            return null;
        }
        if (depth == 2) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = new TreeNode(val);
            root.left.left = left;
            root.right = new TreeNode(val);
            root.right.right = right;
        }
        addOneRow(root.left, val, depth - 1);
        addOneRow(root.right, val, depth - 1);
        return root;
    }

}