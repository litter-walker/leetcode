package com.datastructure;

import com.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈-中序遍历
 */
public class Text0173 {
}

class BSTIterator {

    private final Deque<TreeNode> stack = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode pop = stack.pop();
        TreeNode nextNode = pop.right;
        while (nextNode != null) {
            stack.push(nextNode);
            nextNode = nextNode.left;
        }
        return pop.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
