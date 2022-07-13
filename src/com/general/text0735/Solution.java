package com.general.text0735;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈模拟
 */
public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        /*
            根据题意只有：左边的向右移动，右边向左边移动才能碰撞

            可以使用 栈的方式 将前面没有碰撞的行星保存：
                当新的行星到达时，判断是否碰撞
        */
        Deque<Integer> stack = new LinkedList<>();
        for (int asteroid : asteroids) {
            /*
                如果没有行星在 stack 中，
                或者 栈顶元素为负数，
                或者 asteroid 为正数
                直接将 asteroid 加入栈中
            */
            if (stack.isEmpty() || stack.peek() < 0 || asteroid > 0) {
                stack.push(asteroid);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() + asteroid < 0) {
                stack.pop();
            }
            /*
                如果 栈中没有元素 或者 栈顶元素为负数（向左移动），则直接加入

                新来的行星（向左）没有前面（向右的）行星大
                如果 栈顶元素 与 asteroid 相同，则 asteroid 不入栈 且 消除栈顶
                否则 asteroid 直接消除（不做处理）
            */
            if (stack.isEmpty() || stack.peek() < 0) {
                stack.push(asteroid);
            } else if (stack.peek() + asteroid == 0) {
                stack.pop();
            }
        }
        int n = stack.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = stack.removeLast();
        }
        return ans;
    }
}
