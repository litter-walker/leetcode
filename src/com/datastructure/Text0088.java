package com.datastructure;

import java.util.Arrays;

/**
 *
 */
public class Text0088 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 0) {
            System.arraycopy(nums2, 0, nums1, 0, m + n);
            return;
        }
        if (nums2.length == 0) {
            return;
        }
        int[] ans = new int[m + n];
        int i = 0, j = 0;
        while (i + j < m + n) {
            if (i < m && j < n && nums1[i] < nums2[j]) {
                ans[i + j] = nums1[i++];
            } else if (j < n) {
                ans[i + j] = nums2[j++];
            } else if (i < m) {
                ans[i + j] = nums1[i++];
            }
        }
        System.arraycopy(ans, 0, nums1, 0, m + n);
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 0},nums2 = {1};
        int  m = 1, n = 1;
        System.out.println("nums1 = " + Arrays.toString(nums1));
        System.out.println("nums2 = " + Arrays.toString(nums2));
        System.out.println("n = " + n);
        System.out.println("m = " + m);
        merge(nums1, m, nums2, n);
        System.out.println("nums1 = " + Arrays.toString(nums1));
    }

}
