package com.datastructure;

import com.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归
 */
public class Text0145 {

    public static List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> leftList = postorderTraversal(root.left);
        List<Integer> rightList = postorderTraversal(root.right);
        return new ArrayList<>(){{
            addAll(leftList);
            addAll(rightList);
            add(root.val);
        }};
    }

    public static void main(String[] args) {

    }
}
