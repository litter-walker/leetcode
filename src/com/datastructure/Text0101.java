package com.datastructure;

import com.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * BFS: 双队列
 */
public class Text0101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> leftSub = new LinkedList<>();
        leftSub.offer(root.left);
        Deque<TreeNode> rightSub = new LinkedList<>();
        rightSub.offer(root.right);
        while (!leftSub.isEmpty() && !rightSub.isEmpty()) {
            TreeNode leftPoll = leftSub.poll();
            TreeNode rightPoll = rightSub.poll();
            if (leftPoll != null && rightPoll != null) {
                if (leftPoll.val != rightPoll.val) {
                    return false;
                }
                leftSub.offer(leftPoll.right);
                leftSub.offer(leftPoll.left);
                rightSub.offer(rightPoll.left);
                rightSub.offer(rightPoll.right);
            } else if (leftPoll != null || rightPoll != null) {
                return false;
            }
        }
        return leftSub.isEmpty() && rightSub.isEmpty();
    }

    public static void main(String[] args) {

    }
}
