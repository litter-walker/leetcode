package com.algorithm.doublepointer;

/**
 * 双指针：每次移动较小的指针，记录初始的雨水两边的高度：
 *  如果移动的当前点的值，小于对应边缘值：说明当前点可以装下雨水，则加入雨水数量
 *  如果移动的当前点的值，大于等于对应边缘值：说明当前点不能装下雨水，则改变对应的边缘值
 */
public class Text0042 {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int lh = 0, rh = 0;
        int ans = 0;
        while (l < r) {
            if (height[l] <= height[r]) {
                if (height[l] < lh) {
                    ans += lh - height[l];
                } else {
                    lh = height[l];
                }
                l++;
            } else {
                if (height[r] < rh) {
                    ans += rh - height[r];
                } else {
                    rh = height[r];
                }
                r--;
            }
        }
        return ans;
    }

}
