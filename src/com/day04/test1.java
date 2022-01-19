package com.day04;

import java.util.Arrays;

public class test1 {


    public static void reverseString(char[] s) {

        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }

    }

    public static void main(String[] args) {

        char[] s = {'h', 'e', 'l', 'l','o'};

        reverseString(s);

        System.out.println(Arrays.toString(s));


    }

}
