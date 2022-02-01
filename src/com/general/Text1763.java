package com.general;

/**
 * 使用官方题解：
 */
public class Text1763 {

    public static String longestNiceSubstring(String s) {
        int length = s.length();
        int srcAdd = 0;
        int maxLen = 0;
        for (int i = 0; i < length; i++) {
            int upCaseHash = 0;
            int LowCaseHash = 0;
            for (int j = i; j < length; j++) {
                char ch = s.charAt(j);
                if (ch <= 'Z') {
                    upCaseHash |= 1 << (ch - 'A');
                } else {
                    LowCaseHash |= 1 << (ch - 'a');
                }
                if (upCaseHash == LowCaseHash && j - i + 1 > maxLen) {
                    srcAdd = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(srcAdd, srcAdd + maxLen);
    }

    public static void main(String[] args) {
        String s = "c";
        System.out.println("s = " + s);
        System.out.println("longestNiceSubstring(s) = " + longestNiceSubstring(s));
    }
}
