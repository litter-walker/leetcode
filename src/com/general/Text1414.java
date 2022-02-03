package com.general;

/**
 * 贪心算法：
 *  每次寻找最大的斐波那契数;
 */
public class Text1414 {

    public static int findMinFibonacciNumbers(int k) {
        int ans = 0;
        while (k > 0) {
            int f1 = 1, f2 = 1;
            while (f1 + f2 <= k) {
                int newFib = f1 + f2;
                f1 = f2;
                f2 = newFib;
            }
            ans++;
            k -= f2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int k = 10;
        System.out.println("k = " + k);
        System.out.println("findMinFibonacciNumbers(k) = " + findMinFibonacciNumbers(k));
    }
}
