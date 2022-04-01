package com.general;

import java.util.ArrayList;
import java.util.List;

/**
 * 简单模拟
 */
public class Text0728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        while(left <= right) {
            int temp = left;
            while (temp > 0) {
                if ((temp % 10 == 0) || (left % (temp % 10)) != 0) {
                    break;
                }
                temp /= 10;
            }
            if (temp <= 0) {
                ans.add(left);
            }
            left++;
        }
        return ans;
    }

}
