package com.general;

public class Text2029 {

    public static boolean stoneGameIX(int[] stones) {

        int[] count = new int[3];
        for (int stone : stones) {
            count[stone % 3]++;
        }
        if (count[0] % 2 == 0) {
            return count[1] >= 1 && count[2] >= 1;
        }
        return Math.abs(count[1] - count[2]) > 2;
    }

    public static void main(String[] args) {

    }

}
