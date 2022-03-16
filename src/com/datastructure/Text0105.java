package com.datastructure;

import com.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 分治-递归
 */
public class Text0105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        if (preLen != inLen) {
            throw new RuntimeException("Incorrect input data!!!");
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preLen - 1, inorder, 0, inLen - 1, map);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                               int[] inorder, int inLeft, int inRight, Map<Integer, Integer> map) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int inIdx = map.get(root.val);
        root.left = buildTree(preorder, preLeft + 1, preLeft + inIdx - inLeft,
                inorder, inLeft, inIdx - 1, map);
        root.right = buildTree(preorder, preLeft + inIdx - inLeft + 1, preRight,
                inorder, inIdx + 1, inRight, map);
        return root;
    }
}
