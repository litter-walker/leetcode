package com.algorithm.doublepointer;

/**
 * 快慢指针
 */
public class Text0202 {

    private int getNode(int value) {
        int nextValue = 0;
        while (value > 0) {
            int d = value % 10;
            value /= 10;
            nextValue += d * d;
        }
        return nextValue;
    }
    public boolean isHappy(int n) {
        int fast = getNode(getNode(n)), solw = getNode(n);
        while (fast != 1 && fast != solw) {
            fast = getNode(getNode(fast));
            solw = getNode(solw);
        }
        return fast == 1;
    }

}
