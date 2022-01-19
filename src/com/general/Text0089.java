package com.general;

import java.util.ArrayList;
import java.util.List;

public class Text0089 {

    public static List<Integer> grayCode(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0);
        for (int i = 0; i < n; i++) {
            for (int j = ans.size(); j > 0; j--) {
                ans.add(ans.get(j - 1) | (1 << i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println("n = " + n);
        System.out.println("grayCode(n) = " + grayCode(n));
    }

}
