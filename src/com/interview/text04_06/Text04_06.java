package com.interview.text04_06;

/**
 * 解题思路：
 * 1. 中序遍历：直接使用中序遍历查找p节点
 * 2. 二叉搜索树：利用二叉搜索树特性，找到大于 p 的最小节点
 */
public class Text04_06 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        int target = p.val;
        TreeNode cur = root;
        TreeNode ans = null;
        while (cur != null) {
            if (cur.val > target) {
                ans = cur;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return ans;
    }
}
