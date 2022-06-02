package com.general.text0450;

/**
 * 二叉搜索树
 */
public class Text0450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode newRoot = new TreeNode(10_001);
        newRoot.left = root;
        TreeNode preNode = newRoot;
        while (root != null) {
            int val = root.val;
            if (val < key) {
                preNode = root;
                root = root.right;
            } else if (val > key) {
                preNode = root;
                root = root.left;
            } else {
                deleteNode(preNode, root);
                break;
            }
        }
        return newRoot.left;
    }

    private void deleteNode(TreeNode preNode, TreeNode node) {
        if (node.right == null) {
            if (preNode.left == node) {
                preNode.left = node.left;
            } else {
                preNode.right = node.left;
            }
        } else {
            if (preNode.left == node) {
                preNode.left = node.right;
            } else {
                preNode.right = node.right;
            }
            TreeNode nextNode = node.right;
            while (nextNode.left != null) {
                nextNode = nextNode.left;
            }
            nextNode.left = node.left;
        }
    }
}
