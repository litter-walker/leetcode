package com.general.text1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 排序 + 遍历
 */
public class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (minDiff == arr[i] - arr[i - 1]) {
                ans.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        return ans;
    }
}
