package com.datastructure;

import com.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归
 */
public class Text0094 {

    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> leftList = inorderTraversal(root.left);
        List<Integer> rightList = inorderTraversal(root.right);
        return new ArrayList<>(){{
            addAll(leftList);
            add(root.val);
            addAll(rightList);
        }};
    }

    public static void main(String[] args) {

    }
}
