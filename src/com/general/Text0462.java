package com.general;

import java.util.Arrays;

/**
 * 技巧题
 *  使用中心数作为最后的数字，具体证明如下：
 *      假如数组长度为奇数2n+1，则中位数两边各有n个数
 *      设左边所有数和中位数的差值和为x 右边所有数和中位数的差值和为y 则所有需要移动的次数为x+y
 *      如果不选择中位数 例如选择中位数-1 这样总的移动次数就变成了 >= ((x-n) + (y+n) + 1) 最好的情况下比中位数大1
 *      如果数组长度是偶数 有两个中位数 选择两个中位数的任何一个或者两个中位数的平均数 都是可以的
 *  转载：https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/comments/18707
 */
public class Text0462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        // 中位数
        int mid = nums[nums.length / 2];
        int ans = 0;
        for (int num : nums) {
            ans += Math.abs(mid - num);
        }
        return ans;
    }

}
