package com.general;

import java.util.*;

/**
 * BFS: 层次遍历
 */
@SuppressWarnings("all")
public class Text0429 {

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> inOrderSeq = new ArrayList<>();
        Deque<Node> que = new LinkedList<>();
        que.offer(root);
        // 记录每一层的数量
        int countLevel = 1;
        while (!que.isEmpty()) {
            int curCount = 0;
            List<Integer> curLevelNode = new ArrayList<>();
            inOrderSeq.add(curLevelNode);
            for (int i = 0; i < countLevel; i++) {
                Node poll = que.poll();
                curLevelNode.add(poll.val);
                for (Node child : poll.children) {
                    que.offer(child);
                }
                curCount += poll.children.size();
            }
            countLevel = curCount;
        }
        return inOrderSeq;
    }

}
