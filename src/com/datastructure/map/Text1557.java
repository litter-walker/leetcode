package com.datastructure.map;

import java.util.ArrayList;
import java.util.List;

/**
 * 解题关键：有向无环图
 */
public class Text1557 {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] in = new int[n];
        for (List<Integer> edge : edges) {
            in[edge.get(1)]++;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }

}
