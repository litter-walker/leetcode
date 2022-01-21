package com.general;


import java.util.*;

/**
 * 解题思路：
 * 图：以下标设为节点，当前下标和下一个下标连成一条边；
 * 遍历每一条边，得出全部的结果；
 * 使用BFS得出全部的结果；
 */
public class Text1345 {

    public static int minJumps(int[] arr) {
        int n = arr.length;
        // 保存对应值的节点索引列表，便于下一条的第三种情况
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);
        }
        // 保存访问的index和对应的sept;
        Queue<int[]> queue = new LinkedList<>();
        // 记录index是否访问
        boolean[] visited = new boolean[n];
        queue.offer(new int[]{0, 0});
        visited[0] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int index = poll[0], sept = poll[1];
            if (index == n - 1) {
                return sept;
            }
            if (index < n - 1 && !visited[index + 1]) {
                queue.offer(new int[]{index + 1, sept + 1});
                visited[index + 1] = true;
            }
            if (index > 0 && !visited[index - 1]) {
                queue.offer(new int[]{index - 1, sept + 1});
                visited[index - 1] = true;
            }
            for (Integer newIndex : map.getOrDefault(arr[index], new ArrayList<>())) {
                if (!visited[newIndex]) {
                    queue.offer(new int[]{newIndex, sept + 1});
                    visited[newIndex] = true;
                }
            }
            map.remove(arr[index]);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13};
        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("minJumps(arr) = " + minJumps(arr));
    }
}
