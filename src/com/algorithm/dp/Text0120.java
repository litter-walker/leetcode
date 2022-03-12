package com.algorithm.dp;

import java.util.List;

/**
 * 动态规划
 */
public class Text0120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int newNum;
                if (j == 0) {
                    newNum = triangle.get(i - 1).get(j);
                } else if (j == triangle.get(i).size() - 1) {
                    newNum = triangle.get(i - 1).get(j - 1);
                } else {
                    newNum = Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j));
                }
                newNum += triangle.get(i).get(j);
                triangle.get(i).set(j, newNum);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (Integer num : triangle.get(triangle.size() - 1)) {
            ans = Math.min(ans, num);
        }
        return ans;
    }

}
