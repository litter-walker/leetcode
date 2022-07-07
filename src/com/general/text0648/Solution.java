package com.general.text0648;

import java.util.List;

/**
 * 字典树
 */
public class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Node dicTree = createDicTree(dictionary);

        StringBuilder res = new StringBuilder();
        String[] words = sentence.split(" ");
        // 将每个单词转换为词根
        for (String word : words) {
            res.append(' ').append(rootOfWord(word, dicTree));
        }
        return res.substring(1);
    }

    /**
     * 将单词转换为词根
     */
    private String rootOfWord(String word, Node dicTree) {
        Node node = dicTree;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            sb.append(ch);
            node = node.next[ch - 'a'];
            if (node == null) {
                return word;
            }
            if (node.isRoot) {
                return sb.toString();
            }
        }
        return word;
    }

    /**
     * 构建字典树
     */
    private Node createDicTree(List<String> dictionary) {
        Node res = new Node(' ');

        for (String dic : dictionary) {
            Node node = res;
            for (int i = 0; i < dic.length(); i++) {
                char ch = dic.charAt(i);
                if (node.next[ch - 'a'] == null) {
                    node.next[ch - 'a'] = new Node(ch);
                }
                node = node.next[ch - 'a'];
            }
            node.isRoot = true;
        }
        return res;
    }

    /**
     * 字典树节点
     */
    class Node {
        char curCh; // 当前节点的字母
        Node[] next; // 接下来的字母
        boolean isRoot; // 是否是词根
        public Node(char ch) {
            curCh = ch;
            next = new Node[26];
            isRoot = false;
        }
    }
}
