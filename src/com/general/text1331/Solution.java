package com.general.text1331;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 排序 + 哈希表
 */
public class Solution {

    public int[] arrayRankTransform(int[] arr) {

        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : sortedArr) {
            if (!map.containsKey(num)) {
                map.put(num, map.size() + 1);
            }
        }
        int[] ans = new int[arr.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }

}
