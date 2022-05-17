package com.general;

/**
 * 遍历
 */
public class Text0953 {
    public boolean isAlienSorted(String[] words, String order) {
        // 保存字典序
        int[] orders = new int[26];
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            orders[ch - 'a'] = i;
        }
        // 遍历每一个单词
        int n = words.length;
        for (int i = 1; i < n; i++) {
            String pre = words[i - 1], cur = words[i];
            // 遍历 第i-1个和第i个 单词的每个字母，比较字典序
            for (int j = 0; j < pre.length() && j < cur.length(); j++) {
                char preCh = pre.charAt(j), curCh = cur.charAt(j);
                if (orders[preCh - 'a'] < orders[curCh - 'a']) {
                    break;
                } else if (orders[preCh - 'a'] > orders[curCh - 'a'] ||
                        (j == cur.length() - 1 && j != pre.length() - 1)) {
                    // 如果，第i个单词的第j个字母 小于 第i - 1个单词的第j个单词
                    // 如果，他们相等，但第i个单词更短；
                    return false;
                }
            }
        }
        return true;
    }
}
