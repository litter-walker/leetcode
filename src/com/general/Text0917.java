package com.general;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 解题思路：
 *  栈
 *  如果不是字符串，而是数组：用双指针更好
 */
public class Text0917 {


    public static String reverseOnlyLetters(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
                stack.push(ch);
            }
        }
        StringBuilder ansSB = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
                ch = stack.pop();
            }
            ansSB.append(ch);
        }
        return ansSB.toString();
    }

    public static void main(String[] args) {
        String s = "ab-cd";
        System.out.println("s = " + s);
        System.out.println("reverseOnlyLetters(s) = " + reverseOnlyLetters(s));
    }

}
