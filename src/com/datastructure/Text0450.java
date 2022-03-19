package com.datastructure;

import com.util.TreeNode;

/**
 * 模拟
 */
public class Text0450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode dummy = new TreeNode();
        dummy.left = root;
        TreeNode preNode = dummy;
        TreeNode curNode = root;
        while (curNode != null) {
            if (key == curNode.val) {
                deleteNode(preNode, curNode);
            }
            // 搜索节点
            preNode = curNode;
            if (key < curNode.val) {
                curNode = curNode.left;
            } else {
                curNode = curNode.right;
            }
        }
        return dummy.left;
    }

    private void deleteNode(TreeNode preNode, TreeNode curNode) {

        if (curNode.left == null && curNode.right == null) {
            if (preNode.left == curNode) {
                preNode.left = null;
            } else {
                preNode.right = null;
            }
        } else if (curNode.left == null) {
            if (preNode.left == curNode) {
                preNode.left = curNode.right;
            } else {
                preNode.right = curNode.right;
            }
        } else if (curNode.right == null) {
            if (preNode.left == curNode) {
                preNode.left = curNode.left;
            } else {
                preNode.right = curNode.left;
            }
        } else {
            if (preNode.left == curNode) {
                preNode.left = curNode.right;
            } else {
                preNode.right = curNode.right;
            }
            TreeNode newNode = curNode.right;
            while (newNode.left != null) {
                newNode = newNode.left;
            }
            // 使用左旋
            newNode.left = curNode.left;
        }
    }

}
