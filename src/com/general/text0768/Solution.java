package com.general.text0768;

import java.util.Deque;
import java.util.LinkedList;

/*
    单调栈
 */
public class Solution {
    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> stack = new LinkedList<>();

        for (int num : arr) {
            // 存储当前组的最大值
            int curGroupMax = num;
            while (!stack.isEmpty() && stack.peek() > num) {
                int pop = stack.pop();
                curGroupMax = Math.max(curGroupMax, pop);
            }
            stack.push(curGroupMax);
        }
        return stack.size();
    }
}
