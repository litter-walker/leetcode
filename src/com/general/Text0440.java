package com.general;

/**
 * 字典树
 */
public class Text0440 {

    public int findKthNumber(int n, int k) {
        int count = 1;
        int head = 1;
        while (count < k) {
            int nextCount = getCount(head, n);
            if (count + nextCount > k) {
                head *= 10;
                // 字典向后移动一位
                count++;
            } else if (count + nextCount <= k) {
                head++;
                count += nextCount;
            }
        }
        return head;
    }

    /**
     * 表示以 head 为开始，并且不超过 n 的数字的数量
     * @param head 开始数字
     * @param n 最大数字
     * @return 数量
     */
    private int getCount(int head, int n) {
        int count = 0;
        long left = head, right = left + 1;
        while (left <= n) {
            count += Math.min(n + 1, right) - left;
            left *= 10;
            right *= 10;
        }
        return count;
    }
}
