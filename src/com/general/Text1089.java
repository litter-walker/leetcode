package com.general;

/**
 * 双指针
 */
public class Text1089 {

    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int l = -1, r = 0;
        while (r < n) {
            l++;
            if (arr[l] == 0) {
                r++;
            }
            r++;
        }
        if (r == n + 1) {
            r = n - 1;
            arr[r] = 0;
            r--;
            l--;
        } else {
            r = n - 1;
        }
        while (l >= 0) {
            arr[r] = arr[l];
            r--;
            if (arr[l] == 0) {
                arr[r] = 0;
                r--;
            }
            l--;
        }
    }

}
