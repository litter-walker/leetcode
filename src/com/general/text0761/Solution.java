package com.general.text0761;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
    分治法
 */
public class Solution {
    public String makeLargestSpecial(String s) {
        int n = s.length();
        if (n <= 2) {
            return s;
        }
        int count = 0, left = 0;
        List<String> subs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '1') {
                count++;
            } else {
                count--;
                if (count == 0) {
                    subs.add("1" + makeLargestSpecial(s.substring(left + 1, i)) + "0");
                    left = i + 1;
                }
            }
        }
        subs.sort(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String sub : subs) {
            sb.append(sub);
        }
        return sb.toString();
    }
}
