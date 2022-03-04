package com.algorithm.slidingwindow;

/**
 * 滑动窗口：
 *  记录窗口中的值；
 */
public class Text0567 {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] count = new int[26];
        // 记录count 中 0的数量;
        int zeroCount = 26;
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            if (count[ch - 'a'] == 0) {
                zeroCount--;
            }
            count[ch - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            char chR = s2.charAt(i);
            count[chR - 'a']--;
            if(count[chR - 'a'] == 0) {
                zeroCount++;
            } else if (count[chR - 'a'] == -1) {
                zeroCount--;
            }
            if (i >= s1.length()) {
                char chL = s2.charAt(i - s1.length());
                count[chL - 'a']++;
                if(count[chL - 'a'] == 0) {
                    zeroCount++;
                } else if (count[chL - 'a'] == 1) {
                    zeroCount--;
                }
            }
            if (zeroCount == 26) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
    }

}
