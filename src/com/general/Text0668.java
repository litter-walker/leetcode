package com.general;

/**
 * 二分查找
 */
public class Text0668 {
    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = n * m;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = mid / n * n;
            for (int i = mid / n + 1; i <= m; i++) {
                count += mid / i;
            }
            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(new Text0668().findKthNumber(3, 3, 5));
    }
}
