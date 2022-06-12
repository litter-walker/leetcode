package com.general;

import java.util.ArrayList;
import java.util.List;

/**
 * 双映射
 */
public class Text0890 {
    private final static int CHAR_MAX_NUM = 'z' - 'a' + 1;

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int n = pattern.length();
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            char[] mapPToX = new char[CHAR_MAX_NUM + 1];
            char[] mapXToP = new char[CHAR_MAX_NUM + 1];
            boolean isMatch = true;
            for (int i = 0; i < n; i++) {
                char x = word.charAt(i);
                char p = pattern.charAt(i);
                if (mapPToX[p - 'a' + 1] == 0 && mapXToP[x - 'a' + 1] == 0) {
                    mapPToX[p - 'a' + 1] = x;
                    mapXToP[x - 'a' + 1] = p;
                } else if (mapPToX[p - 'a' + 1] != x || mapXToP[x - 'a' + 1] != p) {
                    isMatch = false;
                    break;
                }

            }
            if (isMatch) {
                ans.add(word);
            }
        }
        return ans;
    }
}
