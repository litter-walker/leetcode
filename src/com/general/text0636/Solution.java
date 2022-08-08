package com.general.text0636;

import java.util.List;

/*
    栈
 */
public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] stack = new int[logs.size() / 2];
        int top = -1;
        int[] ans = new int[n];
        int preTime = -1;
        for (String log : logs) {
            String[] split = log.split(":");
            int fun = Integer.parseInt(split[0]);
            int time = Integer.parseInt(split[2]);
            if (split[1].equals("start")) {
                time--;
                if (top != -1) {
                    ans[stack[top]] += time - preTime;
                }
                stack[++top] = fun;
            } else {
                if (top != -1) {
                    ans[fun] += time - preTime;
                }
                top--;
            }
            preTime = time;
        }
        return ans;
    }
}
