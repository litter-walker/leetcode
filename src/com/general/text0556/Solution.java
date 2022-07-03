package com.general.text0556;

import java.util.ArrayList;

/**
 * 模拟
 */
public class Solution {
    public int nextGreaterElement(int n) {
        //1. 将 n 每一位拆开
        ArrayList<Integer> nList = new ArrayList<>();
        int temp = n;
        while (temp > 0) {
            nList.add(0, temp % 10);
            temp /= 10;
        }
        //2. 重后面遍历，找到第一个开始递减的位数
        int decIndex = nList.size() - 2;
        while (decIndex >= 0 && nList.get(decIndex) >= nList.get(decIndex + 1)) {
            decIndex--;
        }
        // 找不到时，没有比n更大的数字
        if (decIndex < 0) {
            return -1;
        }
        //3. 将第一个递减的位数与后面的比它大的最小的位数进行交换
        int swapIdx = decIndex;
        for (int i = decIndex + 1; i < nList.size(); i++) {
            if (nList.get(decIndex) >= nList.get(i)) {
                break;
            }
            swapIdx = i;
        }
        int x = nList.get(decIndex);
        nList.set(decIndex, nList.get(swapIdx));
        nList.set(swapIdx, x);
        //4. 将后面递增的位进行反转，使得结果最小
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= decIndex; i++) {
            sb.append(nList.get(i));
        }
        for (int i = nList.size() - 1; i > decIndex; i--) {
            sb.append(nList.get(i));
        }
        if (Long.parseLong(sb.toString()) > Integer.MAX_VALUE) {
            return -1;
        }
        return Integer.parseInt(sb.toString());
    }
}
