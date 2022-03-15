package com.datastructure;

import com.util.TreeNode;

/**
 * 递归-分治法
 */
public class Text0108 {

    private int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        int l = 0, r = nums.length - 1;
        return dfs(l, r);
    }

    private TreeNode dfs(int l, int r) {
        if (l == r) {
            return new TreeNode(nums[l]);
        } else if (r < l) {
            return null;
        }
        int mid = l + (r - l) / 2;
        TreeNode ansNode = new TreeNode(nums[mid]);
        ansNode.left = dfs(l, mid - 1);
        ansNode.right = dfs(mid + 1, r);
        return ansNode;
    }


}
