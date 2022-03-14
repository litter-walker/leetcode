package com.datastructure;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈
 */
public class Text1249 {

    public String minRemoveToMakeValid(String s) {
        Deque<Integer> stack = new LinkedList<>();
        StringBuilder ansSB = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(':
                    stack.push(ansSB.length());
                    ansSB.append(ch);
                    break;
                case ')':
                    if (!stack.isEmpty()) {
                        ansSB.append(ch);
                        stack.pop();
                    }
                    break;
                default:
                    ansSB.append(ch);
            }
        }
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            ansSB.deleteCharAt(pop);
        }
        return ansSB.toString();
    }

}
