package com.general;

public class Text1614 {


    public static int maxDepth(String s) {

        int ans = 0;
        int maxAns = ans;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                ans++;
                maxAns = ans > maxAns ? ans : maxAns;
            } else if (ch == ')') {
                ans--;
            }
        }

        return maxAns;
    }

    public static void main(String[] args) {
        String s = "1+(2*3)/(2-1)";
        System.out.println("s = " + s);
        System.out.println("maxDepth(s) = " + maxDepth(s));

    }

}
