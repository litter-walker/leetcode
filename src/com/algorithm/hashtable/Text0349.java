package com.algorithm.hashtable;

import java.util.*;

/**
 * 哈希表
 */
public class Text0349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }
        List<Integer> ansList = new ArrayList<>();
        for (int num : set1) {
            if (set2.contains(num)) {
                ansList.add(num);
            }
        }
        int[] ans = new int[ansList.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }

}
