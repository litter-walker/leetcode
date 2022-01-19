package com.week02;

/**
 * 简单模拟，求解损失秒数；
 */
public class day03 {

    public static int findPoisonedDuration(int[] timeSeries, int duration) {


        int count = duration * timeSeries.length; // 总时间
        // 特殊情况，攻击次数小于2时，没有时间损失
        if(timeSeries.length < 2) {
            return count;
        }
        // 从第1次开始，第0次不会损失前面的中毒时间
        for (int i = 1; i < timeSeries.length; i++) {
            int time_diff = timeSeries[i] - timeSeries[i - 1];
            if (time_diff < duration) {
                count -= duration - time_diff;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] timeSeries = {1,4};
        int duration = 2;
    }


}
