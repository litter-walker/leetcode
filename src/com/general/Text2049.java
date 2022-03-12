package com.general;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS
 */
public class Text2049 {

    private List<Integer>[] children;
    private int n;
    private long maxScore = Long.MIN_VALUE;
    private int count = 1;

    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        children = new List[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int parent = parents[i];
            if (parent != -1) {
                children[parent].add(i);
            }
        }
        dfs(0);
        return count;
    }

    private int dfs(int node) {
        int size = 1;
        long score = 1L;
        for (Integer child : children[node]) {
            int temp = dfs(child);
            score *= temp;
            size += temp;
        }
        // 记录父节点组成的数的节点数量
        if (node != 0) {
            score *= n - size;
        }
        if (score > maxScore) {
            maxScore = score;
            count = 1;
        } else if (maxScore == score) {
            count++;
        }
        return size;
    }

    public static void main(String[] args) {
        int[] parents = {-1,9,3,0,13,2,10,2,18,16,18,5,9,3,4,13,0,12,16};
        System.out.println("new Text2049().countHighestScoreNodes(parents) = " + new Text2049().countHighestScoreNodes(parents));
    }

}
