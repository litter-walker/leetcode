package com.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * 简单模拟+压缩数组
 * 官方解法：倒叙求解，可以避免记忆前一个数据
 */
public class Text0119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        if (rowIndex == 0) {
            return list;
        }
        for (int i = 1; i <= rowIndex; i++) {
            int pre = list.get(0);
            for (int j = 1; j < i; j++) {
                int temp = pre;
                pre = list.get(j);
                list.set(j, temp + list.get(j));
            }
            list.add(1);
        }
        return list;
    }
}
