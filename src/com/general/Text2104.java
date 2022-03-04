package com.general;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 枚举：时间(O(n^2)),空间(O(1))
 * <p>
 * 单调栈：
 * 寻找每个值 为最小值和最大值的区间；
 * 记录每个值的贡献量；
 * 参考题解：https://leetcode-cn.com/problems/sum-of-subarray-ranges/solution/daydayuppp-dan-diao-zhan-on-zuo-fa-by-da-pmmt/
 */
public class Text2104 {

    // 枚举法
/*    public long subArrayRanges(int[] nums) {
        long ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int min = nums[i], max = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                ans += max - min;
            }
        }
        return ans;
    }*/

    // 单调栈
    @SuppressWarnings({"all"})
    public long subArrayRanges(int[] nums) {
        long ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        // 单调递增，记录 每个值取最小值的区间
        for (int i = 0; i < nums.length; i++) {
            while (stack.size() > 1 && nums[stack.peek()] > nums[i]) {
                int pop = stack.pop();
                ans -= (long) nums[pop] * (i - pop) * (pop - stack.peek());
            }
            stack.push(i);
        }
        // 计算剩下的为 开始到最后的最小
        while (stack.size() > 1) {
            int pop = stack.pop();
            ans -= (long) nums[pop] * (nums.length - pop) * (pop - stack.peek());
        }
        // 单调递减，记录 每个值取最大值的区间
        for (int i = 0; i < nums.length; i++) {
            while (stack.size() > 1 && nums[stack.peek()] < nums[i]) {
                int pop = stack.pop();
                ans += (long) nums[pop] * (i - pop) * (pop - stack.peek());
            }
            stack.push(i);
        }
        // 计算剩下的为 开始到最后的最大
        while (stack.size() > 1) {
            int pop = stack.pop();
            ans += (long) nums[pop] * (nums.length - pop) * (pop - stack.peek());
        }
        return ans;
    }


}
