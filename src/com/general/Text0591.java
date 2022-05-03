package com.general;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 */
public class Text0591 {

    public boolean isValid(String code) {

        int n = code.length();
        if (n < 7 || code.charAt(0) != '<') {
            return false;
        }

        Deque<String> tag = new LinkedList<>();
        int start = isStartTagName(code, 0);
        if (start < 0) {
            return false;
        }
        int end = isEndTagName(code, n - start - 2);
        if (end < 0) {
            return false;
        }
        tag.push(code.substring(1, start));
        code = code.replaceAll("<!\\[CDATA\\[(.*?)]]>", "a");
        n = code.length();
        for (int i = start + 1; i < n; i++) {
            char ch = code.charAt(i);
            if (ch == '<') {
                int idx1 = isStartTagName(code, i);
                int idx2 = isEndTagName(code, i);
                if (idx1 > 0) {
                    tag.push(code.substring(i + 1, idx1));
                    i = idx1;
                } else if (idx2 > 0) {
                    String str = code.substring(i + 2, idx2);
                    if (!tag.pop().equals(str)) {
                        return false;
                    }
                    i = idx2;
                } else {
                    return false;
                }
            }
            if (tag.isEmpty() && i < n - 1) {
                return false;
            }
        }
        return tag.isEmpty();
    }

    private int isStartTagName(String code, int start) {
        int n = code.length();
        for (int i = 1; i < 11 && start + i < n; i++) {
            char ch = code.charAt(start + i);
            if (ch == '>') {
                if (i != 1) {
                    return start + i;
                } else {
                    return -1;
                }
            }
            if (!Character.isUpperCase(ch)) {
                return -1;
            }
        }
        return -1;
    }

    private int isEndTagName(String code, int start) {
        if (code.charAt(start + 1) != '/') {
            return -1;
        }
        return isStartTagName(code, start + 1);
    }

}
