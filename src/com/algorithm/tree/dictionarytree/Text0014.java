package com.algorithm.tree.dictionarytree;

/**
 * 字典树
 */
public class Text0014 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder dictTree = new StringBuilder(strs[0]);
        for (String str : strs) {

            for (int i = 0; i < str.length() && i < dictTree.length(); i++) {
                if (str.charAt(i) != dictTree.charAt(i)) {
                    dictTree.delete(i, dictTree.length());
                    break;
                }
            }
            if (str.length() < dictTree.length()) {
                dictTree.delete(str.length(), dictTree.length());
            }
            if (dictTree.length() == 0) {
                break;
            }
        }
        return dictTree.toString();
    }


}
