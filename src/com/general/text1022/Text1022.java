package com.general.text1022;

/**
 * 递归遍历
 */
public class Text1022 {
    private int leafSum = 0;

    public int sumRootToLeaf(TreeNode root) {
        lastOrder(root, 0);
        return leafSum;
    }

    // 递归遍历
    private void lastOrder(TreeNode root, int num) {
        if (root == null) {
            return;
        }
        num *= 2;
        num += root.val;
        if (root.right == null && root.left == null) {
            leafSum += num;
            return;
        }
        lastOrder(root.left, num);
        lastOrder(root.right, num);
    }
}
