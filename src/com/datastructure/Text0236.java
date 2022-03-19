package com.datastructure;

import com.util.TreeNode;

/**
 * 递归：
 *  判断左右节点，是否都存在一个 节点值
 */
public class Text0236 {

    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        if ((left && right) || ((left || right) && (root == p || root == q))) {
            ans = root;
        }
        return left || right || root == p || root == q;
    }

}
