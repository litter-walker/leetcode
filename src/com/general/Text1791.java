package com.general;

import java.util.Arrays;

/**
 * 思考问题：只需要前两个为数字都存在的元素即可
 */
public class Text1791 {

    public static int findCenter(int[][] edges) {
        return edges[0][0] == edges[1][0] ? edges[0][0] : edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }

    public static void main(String[] args) {
        int[][] edges = {{1,2},{2,3},{4,2}};
        System.out.println("edges = " + Arrays.deepToString(edges));
        System.out.println("findCenter(edges) = " + findCenter(edges));
    }
}
