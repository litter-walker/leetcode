package com.datastructure;

import com.util.TreeNode;

import java.util.*;

/**
 * BFS
 */
public class Text0199 {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> ansList = new ArrayList<>();
        Deque<TreeNode> curQue = new LinkedList<>();
        curQue.offer(root);
        while (!curQue.isEmpty()) {
            Deque<TreeNode> nextQue = new LinkedList<>();
            int curValue = 0;
            while (!curQue.isEmpty()) {
                TreeNode poll = curQue.poll();
                curValue = poll.val;
                if (poll.left != null) {
                    nextQue.offer(poll.left);
                }
                if (poll.right != null) {
                    nextQue.offer(poll.right);
                }
            }
            ansList.add(curValue);
            curQue = nextQue;
        }
        return ansList;
    }

}
