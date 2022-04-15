package com.general.text0385;

import java.util.Deque;
import java.util.LinkedList;

/**
 *  栈
 */
@SuppressWarnings("all")
public class Text0385 {
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }
        Deque<NestedInteger> stack = new LinkedList<>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '[':
                    stack.push(new NestedInteger());
                    start = i + 1;
                    break;
                case ',':
                case ']':
                    if (start == i) {
                        NestedInteger pop = stack.pop();
                        stack.peek().add(pop);
                    } else {
                        stack.peek().add(new NestedInteger(Integer.parseInt(s.substring(start))));
                    }
                    start = i + 1;
                    break;
            }
        }
        return stack.pop();
    }

}
