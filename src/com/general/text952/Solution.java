package com.general.text952;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    并查集
 */
public class Solution {
    public int largestComponentSize(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int[] findUnion = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            findUnion[i] = i;
        }
        for (int num : nums) {
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    union(findUnion, num, i);
                    union(findUnion, num, num / i);
                }
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            int root = find(findUnion, num);
            int curCount = map.getOrDefault(root, 0) + 1;
            map.put(root, curCount);
            ans = Math.max(ans, curCount);
        }
        return ans;
    }

    private void union(int[] findUnion, int x, int y) {
        int fx = find(findUnion, x);
        int fy = find(findUnion, y);
        if (fx != fy) {
            findUnion[fx] = fy;
        }
    }

    private int find(int[] findUnion, int x) {
        if (x != findUnion[x]) {
            findUnion[x] = find(findUnion, findUnion[x]);
        }
        return findUnion[x];
    }
}