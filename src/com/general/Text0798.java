package com.general;

/**
 * 差分数组
 */
public class Text0798 {

    public int bestRotation(int[] nums) {
        int n = nums.length;
        int[] diffs = new int[n];
        for (int i = 0; i < n; i++) {
            int low = (i + 1) % n, high = (i + n - nums[i] + 1) % n;
            diffs[low]++;
            diffs[high]--;
            if (low >= high) {
                diffs[0]++;
            }
        }
        int maxSum = 0, minK = 0;
        // 记录前缀和
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += diffs[i];
            if (sum > maxSum) {
                minK = i;
                maxSum = sum;
            }
        }
        return minK;
    }

}
/*
x < n
i < n

x <= i < n:
第一段：0 ~ (i - x)
low = 0;
high = (i - x + n) % n;
第二段：
low = (i + 1) % n
high = i + (n - x) % n

n > x > i:
low = (i + 1) % n
high = i + (n - x) % n
high >= low


0012

 */
