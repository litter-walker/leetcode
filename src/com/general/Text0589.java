package com.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 递归
 */
public class Text0589 {

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> ansList = new ArrayList<>();
        ansList.add(root.val);
        for (Node child : root.children) {
            ansList.addAll(preorder(child));
        }
        return ansList;
    }

}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
