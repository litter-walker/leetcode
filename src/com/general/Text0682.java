package com.general;

/**
 * 简单模拟-栈
 */
public class Text0682 {

    public int calPoints(String[] ops) {
        int n = 1024;
        int ans = 0;
        int[] stack = new int[n];
        int top = -1;
        int pop;
        for (String op : ops) {
            switch (op) {
                case "C":
                    pop = stack[top--];
                    ans -= pop;
                    break;
                case "D":
                    pop = stack[top];
                    stack[++top] = pop * 2;
                    ans += stack[top];
                    break;
                case "+":
                    pop = stack[top];
                    int prePop = stack[top - 1];
                    stack[++top] = pop + prePop;
                    ans += stack[top];
                    break;
                default:
                    stack[++top] = Integer.parseInt(op);
                    ans += stack[top];
            }
        }
        return ans;
    }

}
