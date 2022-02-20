package com.general;

import java.util.Arrays;

/**
 * 简单遍历：
 *  是1，跳2位
 *  是0，跳1位
 */
public class Text0717 {


    public static boolean isOneBitCharacter(int[] bits) {
        boolean ans = true;
        int i = 0;
        while (i < bits.length) {
            if (bits[i] == 1) {
                ans = false;
                i += 2;
            } else {
                ans = true;
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] bits = {0};
        System.out.println("bits = " + Arrays.toString(bits));
        System.out.println("isOneBitCharacter(bits) = " + isOneBitCharacter(bits));
    }
}
