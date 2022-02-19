package com.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 解题思路：
 * 每次将最大的翻到最上面：翻煎饼
 */
public class Text0969 {


    public List<Integer> pancakeSort(int[] arr) {

        List<Integer> ans = new ArrayList<>();
        for (int i = arr.length - 1; i > 0; i--) {
            // 表示为归为的最大值下标
            int curMaxSub = 0;
            for (int j = 0; j <= i; j++) {
                if (arr[curMaxSub] < arr[j]) {
                    curMaxSub = j;
                }
            }
            // 翻转数组
            if (curMaxSub == 0) {
                reversalArr(arr, 0, i);
                ans.add(i + 1);
            } else if (curMaxSub < i) {
                reversalArr(arr, 0, curMaxSub);
                ans.add(curMaxSub + 1);
                reversalArr(arr, 0, i);
                ans.add(i + 1);
            }
        }
        return ans;
    }

    /**
     * 数组翻转函数
     *
     * @param arr 数组
     * @param l   翻转的左下标
     * @param r   翻转的右下标
     */
    private void reversalArr(int[] arr, int l, int r) {
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 1};
        System.out.println("arr = " + Arrays.toString(arr));
        Text0969 text0969 = new Text0969();
        System.out.println("text0969.pancakeSort(arr) = " + text0969.pancakeSort(arr));
    }

}