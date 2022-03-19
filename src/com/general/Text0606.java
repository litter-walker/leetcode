package com.general;

import com.util.TreeNode;

/**
 * 递归
 */
public class Text0606 {

    private final StringBuilder ans = new StringBuilder();
    public String tree2str(TreeNode root) {
        dfs(root);
        return ans.toString();
    }

    private void dfs(TreeNode root) {
        if (root != null) {
            ans.append(root.val);
            if (root.left != null) {
                ans.append('(');
                dfs(root.left);
                ans.append(')');
            } else if (root.right != null) {
                ans.append("()");
            }
            if (root.right != null) {
                ans.append('(');
                dfs(root.right);
                ans.append(')');
            }
        }
    }



}
