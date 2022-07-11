package com.general.text0676;

/**
 * 字典树
 */
public class MagicDictionary {

    private final Node dic;

    public MagicDictionary() {
        dic = new Node();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            Node curNode = dic;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (curNode.next[ch - 'a'] == null) {
                    curNode.next[ch - 'a'] = new Node(ch);
                }
                curNode = curNode.next[ch - 'a'];
            }
            curNode.isEnd = true;
        }
    }

    public boolean search(String searchWord) {

        return dfs(searchWord, dic, 0, false);
    }

    private boolean dfs(String searchWord, Node preNode, int idx, boolean isDiff) {
        if (idx == searchWord.length()) {
            return isDiff && preNode.isEnd;
        }
        char ch = searchWord.charAt(idx);
        if (preNode.next[ch - 'a'] != null) {
            if (dfs(searchWord, preNode.next[ch - 'a'], idx + 1, isDiff)) {
                return true;
            }
        }
        if (!isDiff) {
            for (Node node : preNode.next) {
                if (node != null && node.val != ch) {
                    if (dfs(searchWord, node, idx + 1, true)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    class Node {
        char val;
        Node[] next;
        boolean isEnd;

        public Node() {
            next = new Node[26];
            this.isEnd = false;
        }

        public Node(char _val) {
            this();
            this.val = _val;
        }
    }
}
