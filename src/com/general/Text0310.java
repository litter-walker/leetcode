package com.general;

import java.util.*;

/**
 * 广度优先搜索
 */
@SuppressWarnings("all")
public class Text0310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return new ArrayList<>() {{
                add(0);
            }};
        }
        List<Integer>[] children = new List[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            children[edge[0]].add(edge[1]);
            children[edge[1]].add(edge[0]);
        }
        /*
         * 假设 x~y有最长路
         * x~y 必经过根节点（0），则距离 0 节点最远的节点必然是 x 或者 y中的一个；
         * 另一个节点 可由当前找到的节点得出；
         */
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        int x = findLongestNode(0, children, parent);
        int y = findLongestNode(x, children, parent);
        List<Integer> maxPath = new ArrayList<>();
        parent[x] = -1;
        while (y != -1) {
            maxPath.add(y);
            y = parent[y];
        }
        int pathLen = maxPath.size();
        List<Integer> minHeigthNodes = new ArrayList<>();
        if (pathLen % 2 == 0) {
            minHeigthNodes.add(maxPath.get(pathLen / 2 - 1));
        }
        minHeigthNodes.add(maxPath.get(pathLen / 2));

        return minHeigthNodes;
    }

    private int findLongestNode(int node, List<Integer>[] children, int[] parent) {
        int n = children.length;
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(node);
        boolean[] vistied = new boolean[n];
        vistied[node] = true;

        int longestNode = -1;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            longestNode = poll;
            for (int child : children[poll]) {
                if (!vistied[child]) {
                    vistied[child] = true;
                    parent[child] = poll;
                    queue.offer(child);
                }
            }
        }
        return longestNode;
    }
}
