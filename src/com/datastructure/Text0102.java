package com.datastructure;

import com.util.TreeNode;

import java.util.*;

/**
 * BFS
 */
public class Text0102 {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ansList = new ArrayList<>();
        Deque<TreeNode> nextLevel = new LinkedList<>();
        nextLevel.offer(root);
        while (nextLevel.size() != 0) {
            Deque<TreeNode> curLevel = nextLevel;
            List<Integer> curLevelList = new ArrayList<>();
            nextLevel = new LinkedList<>();
            while (!curLevel.isEmpty()) {
                TreeNode poll = curLevel.poll();
                if (poll.left != null) {
                    nextLevel.offer(poll.left);
                }
                if (poll.right != null) {
                    nextLevel.offer(poll.right);
                }
                curLevelList.add(poll.val);
            }
            ansList.add(curLevelList);
        }
        return ansList;
    }

    public static void main(String[] args) {

    }

}
