package com.algorithm.firstsearch;

import com.util.Node;

import java.util.Deque;
import java.util.LinkedList;

/**
 * BFS
 */
public class Text0116 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> nextNodes = new LinkedList<>();
        nextNodes.offer(root);
        while (!nextNodes.isEmpty()) {
            Deque<Node> curNodes = nextNodes;
            nextNodes = new LinkedList<>();

            Node preNode = root;
            while (!curNodes.isEmpty()) {
                Node curNode = curNodes.poll();
                if (curNode.left != null) {
                    nextNodes.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nextNodes.offer(curNode.right);
                }
                preNode.next = curNode;
                curNode.next = null;
                preNode = curNode;
            }
        }
        root.next = null;
        return root;
    }

}
