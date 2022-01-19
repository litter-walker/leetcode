package com.day03;

import java.util.Arrays;

public class test2 {

    public static int[] twoSum(int[] numbers, int target) {

        int l = 0, r = numbers.length - 1;
        do {
            if(numbers[l] + numbers[r] == target) {
                // 从1开始计数
                return new int[]{l + 1, r + 1};
            } else if (numbers[l] + numbers[r] > target) {
                r--;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            }
        } while(l < r);

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[] numbers = {2,7,11,15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(numbers, target)));

    }

}
