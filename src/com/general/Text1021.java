package com.general;

/**
 * 栈
 */
public class Text1021 {

    public String removeOuterParentheses(String s) {
        int n = s.length();
        // 使用 计数 的方式减小栈空间
        int stack = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            Character ch = s.charAt(i);
            if (ch == '(') {
                stack++;
                if (stack != 0) {
                    sb.append(ch);
                }
            } else {
                stack--;
                if (stack != -1) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }

}
