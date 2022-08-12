package com.general.text1417;

import java.util.ArrayList;
import java.util.List;

/*
    字符串解析
 */
public class Solution {
    public String reformat(String s) {
        List<Character> more = new ArrayList<>();
        List<Character> less = new ArrayList<>();

        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                more.add(ch);
            } else {
                less.add(ch);
            }
        }
        if (more.size() < less.size()) {
            List<Character> temp = more;
            more = less;
            less = temp;
        }
        if (more.size() - less.size() > 1) {
            return "";
        }
        StringBuilder ansSb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                ansSb.append(more.get(i / 2));
            } else {
                ansSb.append(less.get(i / 2));
            }
        }
        return ansSb.toString();
    }
}
