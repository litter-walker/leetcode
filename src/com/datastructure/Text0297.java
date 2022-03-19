package com.datastructure;

import com.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 层次遍历
 */
@SuppressWarnings("all")
public class Text0297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root);
        StringBuilder ansSb = new StringBuilder();
        ansSb.append(root.val);
        while (!que.isEmpty()) {
            TreeNode poll = que.poll();
            if (poll.left == null) {
                ansSb.append(",null");
            } else {
                que.offer(poll.left);
                ansSb.append(',').append(poll.left.val);
            }
            if (poll.right == null) {
                ansSb.append(",null");
            } else {
                que.offer(poll.right);
                ansSb.append(',').append(poll.right.val);
            }
        }
        return ansSb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null")) {
            return null;
        }
        String[] nodes = data.split(",");
        Deque<TreeNode> que = new LinkedList<>();
        int val = Integer.parseInt(nodes[0]);
        TreeNode root = new TreeNode(val);
        que.offer(root);
        for (int i = 1; i < nodes.length; i += 2) {
            TreeNode leftNode, rightNode;
            if (nodes[i].equals("null")) {
                leftNode = null;
            } else {
                leftNode = new TreeNode(Integer.parseInt(nodes[i]));
            }
            if (nodes[i + 1].equals("null")) {
                rightNode = null;
            } else {
                rightNode = new TreeNode(Integer.parseInt(nodes[i + 1]));
            }
            TreeNode poll = que.poll();
            if (leftNode != null) {
                poll.left = leftNode;
                que.offer(leftNode);
            }
            if (rightNode != null) {
                poll.right = rightNode;
                que.offer(rightNode);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        Text0297 text0297 = new Text0297();
        System.out.println("text0297.serialize(root) = " + text0297.serialize(root));
        text0297.deserialize(text0297.serialize(root));
    }
}
