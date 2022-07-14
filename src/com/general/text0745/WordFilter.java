package com.general.text0745;

import java.util.HashMap;
import java.util.Map;

/**
 * 字典树
 */
public class WordFilter {

    Node dic;

    public WordFilter(String[] words) {
        // 初始化空间
        dic = new Node(-1);

        // 构建 字典树
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int len = word.length();
            Node curNode = dic;
            for (int j = 0; j < len; j++) {
                Node tmp = curNode;
                for (int k = j; k < len; k++) {
                    String key = new StringBuilder()
                            .append(word.charAt(k))
                            .append('#')
                            .toString();
                    if (!tmp.children.containsKey(key)) {
                        tmp.children.put(key, new Node(i));
                    }
                    tmp = tmp.children.get(key);
                    tmp.index = i;
                }
                tmp = curNode;
                for (int k = j; k < len; k++) {
                    String key = new StringBuilder()
                            .append('#')
                            .append(word.charAt(len - k - 1))
                            .toString();
                    if (!tmp.children.containsKey(key)) {
                        tmp.children.put(key, new Node(i));
                    }
                    tmp = tmp.children.get(key);
                    tmp.index = i;
                }
                String key = new StringBuilder()
                        .append(word.charAt(j))
                        .append(word.charAt(len - j - 1))
                        .toString();
                if (!curNode.children.containsKey(key)) {
                    curNode.children.put(key, new Node(i));
                }
                curNode = curNode.children.get(key);
                curNode.index = i;
            }
        }
    }

    public int f(String pref, String suff) {
        Node curNode = dic;
        int maxLen = Math.max(pref.length(), suff.length());
        for (int i = 0; i < maxLen; i++) {
            char ch1 = i < pref.length() ? pref.charAt(i) : '#';
            char ch2 = i < suff.length() ? suff.charAt(suff.length() - i - 1) : '#';
            String key = new StringBuilder().append(ch1).append(ch2).toString();
            if (!curNode.children.containsKey(key)) {
                return -1;
            }
            curNode = curNode.children.get(key);
        }
        return curNode.index;
    }


    class Node {

        Map<String, Node> children;
        int index;

        public Node(int index) {
            children = new HashMap<>();
            this.index = index;
        }
    }
}