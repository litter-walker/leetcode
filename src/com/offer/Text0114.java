package com.offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * DFS+权重
 */
public class Text0114 {
    public String alienOrder(String[] words) {
        int n = words.length;
        int[] weight = new int[26];
        Map<Character, HashSet<Character>> mapCompare = new HashMap<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                weight[word.charAt(i) - 'a'] = 1;
                mapCompare.putIfAbsent(word.charAt(i), new HashSet<>());
            }
        }
        for (int i = 1; i < n; i++) {
            String preStr = words[i - 1];
            String curStr = words[i];
            if (preStr.length() > curStr.length() && preStr.startsWith(curStr)) {
                return "";
            }
            int idx1 = 0, idx2 = 0;
            while (idx1 < preStr.length() && idx2 < curStr.length()) {
                char preCh = preStr.charAt(idx1);
                char curCh = curStr.charAt(idx2);
                if (preCh != curCh) {
                    if (mapCompare.get(curCh).contains(preCh)) {
                        return "";
                    } else {
                        mapCompare.get(preCh).add(curCh);
                        break;
                    }
                }
                idx1++;
                idx2++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (isCircle((char) ('a' + i), mapCompare, weight, new HashSet<>())) {
                return "";
            }
            dfs((char) ('a' + i), mapCompare, weight);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            int maxIdx = 0;
            for (int j = 1; j < 26; j++) {
                if (weight[j] > weight[maxIdx]) {
                    maxIdx = j;
                }
            }
            if (weight[maxIdx] == 0) {
                break;
            }
            sb.append((char)(maxIdx + 'a'));
            weight[maxIdx] = 0;
        }
        return sb.toString();
    }

    private int dfs(char ch, Map<Character, HashSet<Character>> mapCompare, int[] weight) {
        if (weight[ch - 'a'] == 1) {
            HashSet<Character> set = mapCompare.get(ch);
            for (Character character : set) {
                weight[ch - 'a'] += dfs(character, mapCompare, weight) + 1;
            }
        }
        return weight[ch - 'a'];
    }

    private boolean isCircle(char ch, Map<Character, HashSet<Character>> mapCompare, int[] weight, Set<Character> visited) {
        if (!visited.add(ch)) {
            return true;
        }
        if (weight[ch - 'a'] == 1) {
            HashSet<Character> set = mapCompare.get(ch);
            for (Character character : set) {
                if (isCircle(character, mapCompare, weight, visited)) {
                    return true;
                }
            }
        }
        visited.remove(ch);
        return false;
    }
}
