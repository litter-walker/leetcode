package com.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 滑动窗口 + 哈希表<p>
 *
 *  解题思路：<p>
 *  参考
 *  <a href = "https://leetcode.cn/problems/substring-with-concatenation-of-all-words/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-6/">详细通俗的思路分析，多解法<a/>
 */
public class Text0030 {
    public List<Integer> findSubstring(String s, String[] words) {
        int m = words.length, n = words[0].length();
        Map<String, Integer> wordMap = new HashMap<>();
        // 创建哈希表
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();
        // 使用滑动窗口遍历 i + m * n <= s.length()
        for (int i = 0; i <= s.length() - m * n; i++) {
            int count = 0;
            Map<String, Integer> curWindowWordMap = new HashMap<>();
            while (count < m) {
                String curWord = s.substring(i + count * n, i + (count + 1) * n);
                if (wordMap.containsKey(curWord)) {
                    int curWordCount = curWindowWordMap.getOrDefault(curWord, 0) + 1;
                    if (curWordCount > wordMap.get(curWord)) {
                        break;
                    }
                    curWindowWordMap.put(curWord, curWordCount);
                } else {
                    break;
                }
                count++;
            }
            if (count == m) {
                ans.add(i);
            }
        }
        return ans;
    }
}
