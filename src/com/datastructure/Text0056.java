package com.datastructure;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

/**
 *
 */
public class Text0056 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Deque<int[]> stack = new LinkedList<>();
        for (int[] interval : intervals) {
            if (stack.isEmpty()) {
                stack.push(interval);
                continue;
            }
            int[] peek = stack.peek();
            if (peek[1] < interval[0]) {
                stack.push(interval);
            } else if (peek[1] < interval[1]) {
                stack.pop();
                stack.push(new int[]{peek[0],interval[1]});
            }
        }
        return stack.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        new Text0056().merge(intervals);
    }

}
