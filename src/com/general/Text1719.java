package com.general;

import java.util.*;

/**
 * 官方思路：模拟
 *
 */
public class Text1719 {


    public static int checkWays(int[][] pairs) {
        if (pairs.length == 1) {
            return 2;
        }
        // 节点-节点可以到达的节点 Map
        Map<Integer, Set<Integer>> nodeMap = new HashMap<>();
        for (int[] pair : pairs) {
            int x = pair[0], y = pair[1];
            nodeMap.putIfAbsent(x, new HashSet<>());
            nodeMap.get(x).add(y);
            nodeMap.putIfAbsent(y, new HashSet<>());
            nodeMap.get(y).add(x);
        }
        // 检查是否存在根节点
        int root = -1;
        for (Map.Entry<Integer, Set<Integer>> entry : nodeMap.entrySet()) {
            if (entry.getValue().size() == nodeMap.size() - 1) {
                root = entry.getKey();
            }
        }
        if (root == -1) {
            return 0;
        }
        // 检查每个节点的相邻节点，是否存在以下情况
        // 1. 父节点：父节点可到达节点包含当前节点的可到达节点；
        // 2. 可交换节点：可到达节点和当前节点相同；
        // 如果不存在，则不是一棵树
        int ans = 1;
        for (Map.Entry<Integer, Set<Integer>> entry : nodeMap.entrySet()) {
            int key = entry.getKey();
            Set<Integer> value = entry.getValue();
            // root 没有父节点
            if (key == root) {
                continue;
            }
            int curSize = value.size();
            int parent = -1;
            int parentNodeNum = Integer.MAX_VALUE;
            for (Integer node : value) {
                int size = nodeMap.get(node).size();
                if (size < parentNodeNum && size >= curSize) {
                    parent = node;
                    parentNodeNum = size;
                }
            }
            if (parent == -1) {
                return 0;
            }
            for (Integer node : value) {
                if (node == parent) {
                    continue;
                }
                if (!nodeMap.get(parent).contains(node)) {
                    return 0;
                }
            }
            if (parentNodeNum == curSize) {
                ans = 2;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] pairs = {{1,2},{2,3},{1,3}};
        System.out.println("pairs = " + Arrays.deepToString(pairs));
        System.out.println("checkWays(pairs) = " + checkWays(pairs));
    }
}
