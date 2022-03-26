package com.algorithm.doublepointer;

/**
 * 双指针
 */
public class Text0392 {

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        for (int si = 0, ti = 0; ti < t.length(); ti++) {
            if (s.charAt(si) == t.charAt(ti)) {
                si++;
                if (si == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }

}
