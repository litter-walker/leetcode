package com.datastructure;

import com.util.TreeNode;

/**
 * 中序遍历
 */
public class Text0230 {

    private int k;
    private int ans;
    private boolean finish;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        this.finish = false;
        inOrder(root);
        if (this.k != 1) {
            throw new RuntimeException("the kth smallest element does not exist");
        }
        return ans;
    }

    // 中序遍历
    private void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            if (finish) {
                return;
            }
            if (k == 1) {
                ans = node.val;
                finish = true;
                return;
            }
            k--;
            inOrder(node.right);
        }
    }

}
