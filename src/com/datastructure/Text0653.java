package com.datastructure;

import com.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历：得到升序排列
 * 使用双指针寻找 sum == k
 */
public class Text0653 {
    private final List<Integer> values = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        inorderTraversal(root);
        if (values.size() < 2) {
            return false;
        }
        int l = 0, r = values.size() - 1;
        while (l < r) {
            int sum = values.get(l) + values.get(r);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                l++;
            } else {
                r--;
            }
        }
        return false;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        values.add(root.val);
        inorderTraversal(root.right);
    }

}
