package com.general;

/**
 * 递归遍历/二进制枚举
 */
public class Text2044 {

    private int n;
    private int[] nums;
    private int maxValue;
    private int count;

    public int countMaxOrSubsets(int[] nums) {
        this.nums = nums;
        n = nums.length;
        maxValue = 0;
        count = 0;
        dfs(0, 0);
        return count;
    }

    private void dfs(int curValue, int idx) {
        if (idx == this.n) {
            return;
        }
        int newValue = nums[idx] | curValue;
        if (newValue > maxValue) {
            maxValue = newValue;
            count = 1;
        } else if (newValue == maxValue) {
            count++;
        }
        // 不选
        dfs(curValue, idx + 1);
        // 选
        dfs(newValue, idx + 1);
    }

}
