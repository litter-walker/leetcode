package com.algorithm.recurseorbacktrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 二进制枚举
 */
public class Text0784 {

    public List<String> letterCasePermutation(String s) {
        // 记录字母的数量
        int top = 0;
        // 记录字母元素的位置
        int[] position = new int[12];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z' || chars[i] >= 'A' && chars[i] <= 'Z') {
                position[top++] = i;
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 1 << top; i++) {
            for (int j = 0; j < top; j++) {
                if (((i >> j) & 1) == 1) {
                    chars[position[j]] = Character.toUpperCase(chars[position[j]]);
                } else {
                    chars[position[j]] = Character.toLowerCase(chars[position[j]]);
                }
            }
            ans.add(new String(chars));
        }
        return ans;
    }

}
