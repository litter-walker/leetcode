package com.datastructure;

import com.util.TreeNode;

/**
 * 注意：公共祖先可以是自身
 * p，q 不可能分布在公共节点的同一侧
 */
public class Text0235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 保证p小于q
        int pv = p.val;
        int qv = q.val;
        if (pv > qv) {
            return lowestCommonAncestor(root, q, p);
        }

        int rv = root.val;
        if (rv >= pv && rv <= qv) {
            return root;
        } else if (rv < pv) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return lowestCommonAncestor(root.left, p, q);
        }
    }

}
