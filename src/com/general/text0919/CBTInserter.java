package com.general.text0919;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 使用数组表示树
 */
public class CBTInserter {
    private TreeNode[] tree;
    private int top;

    public CBTInserter(TreeNode root) {
        this.tree = new TreeNode[10004];
        top = -1;
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            TreeNode curNode = que.poll();
            tree[++top] = curNode;
            if (curNode.left != null) {
                que.offer(curNode.left);
            }
            if (curNode.right != null) {
                que.offer(curNode.right);
            }
        }
    }

    public int insert(int val) {
        tree[++top] = new TreeNode(val);
        TreeNode preNode = tree[(top - 1) / 2];
        if (top % 2 == 1) {
            preNode.left = tree[top];
        } else {
            preNode.right = tree[top];
        }
        return preNode.val;
    }

    public TreeNode get_root() {
        return tree[0];
    }
}
