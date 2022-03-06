package com.general;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 正难反易：找出不适合打劫的日子
 * 栈：记录数量 ----> 改进：使用常数空间复杂度，记录数量即可
 */
public class Text2100 {

    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;

        List<Integer> ans = new ArrayList<>();
        if (time == 0) {
            for (int i = 0; i < n; i++) {
                ans.add(i);
            }
            return ans;
        }
        if (time * 2 > n) {
            return ans;
        }
        // 记录 不合适的打劫日子
        boolean[] unsuitable = new boolean[n];
        // 前面满足非递减/递增条件的元素个数
        int count = 1;
        // 判断第 i 天前连续 time 天警卫数目都是非递增的。
        for (int i = 1; i < n; i++) {
            if (count < time) {
                unsuitable[i - 1] = true;
            }
            if(security[i] <= security[i - 1]) {
                count++;
            } else {
                count = 0;
            }
        }
        // 判断第 i 天后连续 time 天警卫数目都是非递减的。
        for (int i = n - 1; i > 0; i--) {
            if (count < time) {
                unsuitable[i] = true;
            }
            if(security[i] >= security[i - 1]) {
                count++;
            } else {
                count = 0;
            }
        }
        for (int i = time; i < n - time; i++) {
            if (!unsuitable[i]) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] security = {2,0,5,3,4};
        int time = 1;
        System.out.println("new Text2100().goodDaysToRobBank(security, time) = " + new Text2100().goodDaysToRobBank(security, time));
    }

}
