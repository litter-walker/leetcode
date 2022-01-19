package com.general;

import java.util.*;

public class Text0539 {

    private static int MAX_TIME = 24 * 60;
    public static int findMinDifference(List<String> timePoints) {


        if (timePoints.size() > MAX_TIME) {
            return 0;
        }
        int[] timesCount = new int[MAX_TIME * 2 + 1];
        for (String timePoint : timePoints) {
            String[] split = timePoint.split(":");
            int h = Integer.parseInt(split[0]);
            int m = Integer.parseInt(split[1]);
            timesCount[h * 60 + m]++;
            timesCount[h * 60 + m + MAX_TIME]++;
        }
        // 表示上一个时间节点;
        int last = -1;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < timesCount.length; i++) {
            if (timesCount[i] == 0) {
                continue;
            }
            if (timesCount[i] > 1) {
                return 0;
            } else if (last != -1) {
                ans = Math.min(ans, i - last);
            }
            last = i;
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] timePoints = {"00:00", "00:00"};
        System.out.println("timePoints = " + Arrays.toString(timePoints));
        System.out.println("findMinDifference(timePoints) = " + findMinDifference(Arrays.asList(timePoints)));
    }
}
