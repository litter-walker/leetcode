package com.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Text0373 {

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<int[]> heapQ = new PriorityQueue<>(
                (a, b) -> nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]
        );
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            heapQ.offer(new int[]{i, 0});
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (!heapQ.isEmpty() && k-- > 0) {
            int[] poll = heapQ.poll();
            ans.add(new ArrayList<>() {
                {
                    add(nums1[poll[0]]);
                    add(nums2[poll[1]]);
                }
            });
            if (poll[1] < nums2.length - 1) {
                heapQ.offer(new int[]{poll[0], poll[1] + 1});
            }

        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums1 = {1,1,2};
        int[] nums2 = {1,2,3};
        int k = 2;
        System.out.println("nums1 = " + Arrays.toString(nums1));
        System.out.println("nums2 = " + Arrays.toString(nums2));
        System.out.println("kSmallestPairs(nums1, nums2) = " + kSmallestPairs(nums1, nums2, k));

    }
}
