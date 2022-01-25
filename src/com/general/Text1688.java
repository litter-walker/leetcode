package com.general;

public class Text1688 {

    public static int numberOfMatches(int n) {
        int ans = 0;
        int modMore = 0;
        int curNum = n + modMore;
        while (n + modMore > 1) {
            curNum = n + modMore;
            ans += curNum >> 1;
            n = curNum >> 1;
            modMore = curNum % 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 100;
        System.out.println("n = " + n);
        System.out.println("numberOfMatches(n) = " + numberOfMatches(n));
    }
}
