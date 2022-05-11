package com.general.text0449;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 层次遍历
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root);
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = que.poll();
                if (poll != null && poll.left != null) {
                    que.offer(poll.left);
                    sb.append(',').append(poll.left.val);
                } else {
                    sb.append(',').append("-1");
                }
                if (poll != null && poll.right != null) {
                    que.offer(poll.right);
                    sb.append(',').append(poll.right.val);
                } else {
                    sb.append(',').append("-1");
                }
            }
        }
        return sb.toString();
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] nodeStr = data.split(",");
        int n = nodeStr.length;
        Integer[] node = new Integer[n];
        for (int i = 0; i < n; i++) {
            node[i] = Integer.parseInt(nodeStr[i]);
        }
        TreeNode root = new TreeNode(node[0]);
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int idx = 1;
        while (!que.isEmpty()) {
            TreeNode poll = que.poll();
            if (node[idx] != -1) {
                poll.left = new TreeNode(node[idx]);
                que.offer(poll.left);
            }
            idx++;
            if (node[idx] != -1) {
                poll.right = new TreeNode(node[idx]);
                que.offer(poll.right);
            }
            idx++;
        }
        return root;
    }
}
