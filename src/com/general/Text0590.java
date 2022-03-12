package com.general;

import java.util.ArrayList;
import java.util.List;

/**
 * dfs
 */
public class Text0590 {

    private final List<Integer> ans = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root != null) {
            dfs(root);
        }
        return ans;
    }

    private void dfs(Node node) {
        for (Node child : node.children) {
            dfs(child);
        }
        ans.add(node.val);
    }

}
