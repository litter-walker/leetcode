package com.datastructure;

import com.util.TreeNode;

import java.util.*;

/**
 * BFS
 */
public class Text0103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> ans = new ArrayList<>();
        boolean isReverse = false;
        Deque<TreeNode> curQue = new LinkedList<>();
        curQue.offer(root);
        while (!curQue.isEmpty()) {
            Deque<TreeNode> nextQue = new LinkedList<>();
            List<Integer> curList = new ArrayList<>();
            while (!curQue.isEmpty()) {
                TreeNode poll = curQue.poll();
                if (poll.left != null) {
                    nextQue.offer(poll.left);
                }
                if (poll.right != null) {
                    nextQue.offer(poll.right);
                }
                curList.add(poll.val);
            }
            if (isReverse) {
                List<Integer> list = new ArrayList<>();
                for (int i = curList.size() - 1; i >= 0; i--) {
                    list.add(curList.get(i));
                }
                ans.add(list);
            } else {
                ans.add(curList);
            }
            curQue = nextQue;
            isReverse = !isReverse;
        }
        return ans;
    }
}
