package com.datastructure;

import java.util.*;

/**
 * Hash表
 */
public class Text0350 {

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num)) {
                int count = map.get(num);
                list.add(num);
                map.put(num, count - 1);
                if (count == 1) {
                    map.remove(num);
                }
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
        System.out.println("nums1 = " + Arrays.toString(nums1));
        System.out.println("nums2 = " + Arrays.toString(nums2));
        System.out.println("intersect(nums1, nums2) = " + Arrays.toString(intersect(nums1, nums2)));
    }
}
