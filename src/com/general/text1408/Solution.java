package com.general.text1408;

import java.util.ArrayList;
import java.util.List;

/*
    枚举
 */
public class Solution {
    public List<String> stringMatching(String[] words) {
        int n = words.length;

        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && words[j].contains(words[i])) {
                    res.add(words[i]);
                    break;
                }
            }
        }

        return res;
    }
}
