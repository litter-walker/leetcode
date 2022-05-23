package com.general;

import java.util.*;

/**
 * BFS
 */
public class Text0675 {
    private static final int[] dirs = {-1, 0, 1, 0, -1};
    private int m;
    private int n;
    private List<List<Integer>> forest;

    public int cutOffTree(List<List<Integer>> forest) {
        // 初始化
        this.forest = forest;
        m = forest.size();
        n = forest.get(0).size();
        // 按照数的高度，将位置排序
        List<int[]> places = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1) {
                    places.add(new int[]{i, j});
                }
            }
        }
        places.sort(Comparator.comparingInt(a -> forest.get(a[0]).get(a[1])));
        // 统计路径长度
        int sum = bfs(new int[]{0, 0}, places.get(0));
        for (int i = 1; i < places.size(); i++) {
            int[] start = places.get(i - 1);
            int[] end = places.get(i);
            // 出现无法到达的地址时，直接返回 -1
            int cur = bfs(start, end);
            if (cur == -1) {
                return -1;
            }
            sum += cur;
        }
        return sum;
    }

    private int bfs(int[] start, int[] end) {
        Deque<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        que.offer(start);
        visited[start[0]][start[1]] = true;
        int path = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int[] poll = que.poll();
                assert poll != null;
                if (poll[0] == end[0] && poll[1] == end[1]) {
                    return path;
                }
                for (int j = 1; j < dirs.length; j++) {
                    int nextX = poll[0] + dirs[j - 1];
                    int nextY = poll[1] + dirs[j];
                    if (nextX >= 0 && nextX < m &&
                            nextY >= 0 && nextY < n &&
                            !visited[nextX][nextY] && forest.get(nextX).get(nextY) > 0) {
                        que.offer(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
            path++;
        }
        return -1;
    }

}
