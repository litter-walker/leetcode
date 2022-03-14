package com.datastructure;

/**
 *
 */
public class Text0155 {

}

class MinStack {

    private static final int MAX_LENGTH = (int) (3 * 1E4);
    private int[] stack;
    private int[] minValue;
    private int top;

    public MinStack() {
        stack = new int[MAX_LENGTH];
        minValue = new int[MAX_LENGTH];
        top = -1;
    }

    public void push(int val) {
        stack[++top] = val;
        if (top == 0) {
            minValue[top] = val;
        } else {
            minValue[top] = Math.min(minValue[top - 1], val);
        }
    }

    public void pop() {
        top--;
    }

    public int top() {
        return stack[top];
    }

    public int getMin() {
        return minValue[top];
    }
}
