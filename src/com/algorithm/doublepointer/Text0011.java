package com.algorithm.doublepointer;

/**
 * 双指针：
 * 分析：
 *  每次收缩：
 *      1. 移动短板，面积可能减小、不变、增大
 *      2. 移动长板，面积可能减小、不变、不可能增大
 *  综上所述：
 *      每次收缩短板，才有可能增大面积
 */
public class Text0011 {

    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0, r= height.length - 1;
        while (l < r) {
            if (height[l] > height[r]) {
                maxArea = Math.max(height[r] * (r - l), maxArea);
                r--;
            } else {
                maxArea = Math.max(height[l] * (r - l), maxArea);
                l++;
            }
        }
        return maxArea;
    }

}
