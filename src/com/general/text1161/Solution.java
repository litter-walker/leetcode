package com.general.text1161;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/*
    BFS-层次遍历
 */
public class Solution {
    public int maxLevelSum(TreeNode root) {
        int ans = 1, maxSum = root.val;
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int level = 1;
        while (!que.isEmpty()) {
            int sum = 0;
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = que.poll();
                sum += Objects.requireNonNull(poll).val;
                if (poll.left != null) {
                    que.offer(poll.left);
                }
                if (poll.right != null) {
                    que.offer(poll.right);
                }
            }
            if (sum > maxSum) {
                ans = level;
                maxSum = sum;
            }
            level++;
        }
        return ans;
    }
}
