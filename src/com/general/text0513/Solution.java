package com.general.text0513;

import java.util.Deque;
import java.util.LinkedList;

/**
 * BFS
 * 两种方案
 * 1. 每层遍历前计数
 * 2. 每层遍历时，从右向左遍历，那么最后一个一定是 最底部的最右边节点
 */
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int ans = 0;
        while (!que.isEmpty()) {
            ans = que.peek().val;
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = que.poll();
                assert poll != null;
                if (poll.left != null) {
                    que.offer(poll.left);
                }
                if (poll.right != null) {
                    que.offer(poll.right);
                }
            }
        }
        return ans;
    }
}
