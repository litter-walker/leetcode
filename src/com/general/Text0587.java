package com.general;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 *
 */
public class Text0587 {
    public int[][] outerTrees(int[][] trees) {
        int n = trees.length;
        if (n <= 3) {
            return trees;
        }
        int idxOrigin = 0;
        for (int i = 0; i < n; i++) {
            if (trees[i][1] < trees[idxOrigin][1] ||
                    (trees[i][1] == trees[idxOrigin][1] && trees[i][0] >= trees[idxOrigin][0])) {
                idxOrigin = i;
            }
        }
        swap(trees[0], trees[idxOrigin]);

        int[] origin = {trees[0][0], trees[0][1]};
        Arrays.sort(trees, 1, n, (a, b) -> {
            int diff = inverseSlope(a, b, origin);
            if (diff == 0) {
                return a[1] == b[1] ? a[0] - b[0] : b[1] - a[1];
            } else {
                return diff;
            }
        });

        int end = 0;
        while (end + 1 < n && inverseSlope(trees[end], trees[end + 1], trees[0]) == 0) {
            end++;
        }
        reversal(1, end, trees);

        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        stack.push(1);
        for (int i = 2; i < n; i++) {
            int pop = stack.pop();
            while (!stack.isEmpty() && inverseSlope(trees[stack.peek()], trees[i], trees[pop]) < 0) {
                pop = stack.pop();
            }
            stack.push(pop);
            stack.push(i);
        }
        int size = stack.size();
        int[][] ans = new int[size][2];
        for (int i = 0; i < size; i++) {
            ans[i] = trees[stack.pop()];
        }
        return ans;
    }

    private int inverseSlope(int[] a, int[] b, int[] origin) {
        return (a[0] - origin[0]) * (b[1] - origin[1]) - (a[1] - origin[1]) * (b[0] - origin[0]);
    }

    private void swap(int[] a, int[] b) {
        int temp0 = a[0], temp1 = a[1];
        a[0] = b[0];
        a[1] = b[1];
        b[0] = temp0;
        b[1] = temp1;
    }

    private void reversal(int l, int r, int[][] arr) {
        while (l < r) {
            swap(arr[l], arr[r]);
            l++;
            r--;
        }
    }

}
