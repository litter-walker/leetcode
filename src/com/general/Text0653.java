package com.general;

import com.util.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 哈希表 + 递归遍历
 */
public class Text0653 {

    private final Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

}
