package com.datastructure;

import com.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归
 */
public class Text0144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> leftList = preorderTraversal(root.left);
        List<Integer> rightList = preorderTraversal(root.right);
        return new ArrayList<>(){{
            add(root.val);
            addAll(leftList);
            addAll(rightList);
        }};
    }


    public static void main(String[] args) {

    }
}

