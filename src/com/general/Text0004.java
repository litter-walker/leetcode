package com.general;

import java.util.Arrays;

public class Text0004 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        int l = 0;
        int r = m - 1;
        while (l < r) {
            int i = l + (r - l + 1) / 2;
            int j = m + n - i;
            if (nums1[i - 1] > nums2[j]) {
                r = i - 1;
            } else {
                l = i;
            }
        }
        int num_i = 1;
        return 0;

    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};


        System.out.println("nums1 = " + Arrays.toString(nums1));
        System.out.println("nums2 = " + Arrays.toString(nums2));
        System.out.println("findMedianSortedArrays(nums1, nums2) = " + findMedianSortedArrays(nums1, nums2));

    }
}
