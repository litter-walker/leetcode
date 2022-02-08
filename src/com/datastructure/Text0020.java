package com.datastructure;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 栈
 */
public class Text0020 {

    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>(){
            {
                put(']', '[');
                put(')', '(');
                put('}', '{');
            }
        };
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty() || stack.pop() != map.get(ch)) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(([)])";
        System.out.println("s = " + s);
        System.out.println("isValid(s) = " + isValid(s));
    }

}
