package com.general.text0324;

import java.util.Arrays;

/**
 * 排序
 *  判断出 数组中的相同数字数量一定小于 n / 2 + 1;
 *  因此，相隔 n / 2 + 1 个数字的数量一定大于
 */
public class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int l = (n + 1) / 2 - 1, r = n - 1;
        for (int i = 0; i < n; i += 2) {
            nums[i] = arr[l];
            if (i + 1 < n) {
                nums[i + 1] = arr[r];
            }
            l--;
            r--;
        }
    }
}
