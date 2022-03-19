package com.datastructure.map;

import java.util.List;

/**
 * DFS
 */
public class Text0841 {

    private boolean[] visited;
    private int count;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        this.visited = new boolean[n];
        this.count = 1;
        visited[0] = true;
        dfs(rooms.get(0), rooms);
        return this.count == n;
    }

    private void dfs(List<Integer> list, List<List<Integer>> rooms) {
        for (Integer no : list) {
            if (!visited[no]) {
                visited[no] = true;
                this.count++;
                dfs(rooms.get(no), rooms);
            }
        }
    }

}
