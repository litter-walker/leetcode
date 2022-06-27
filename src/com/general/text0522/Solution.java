package com.general.text0522;

/**
 * 枚举 + 双指针
 */
public class Solution {
    public int findLUSlength(String[] strs) {
        int n = strs.length;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            // 判断strs[i]是否是特殊的
            boolean check = true;
            for (int j = 0; j < n; j++) {
                if (i != j && isSubStr(strs[i], strs[j])) {
                    check = false;
                    break;
                }
            }
            if (check) {
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }

    /**
     * 判断 strSub 是否是 str 的子串
     * @param strSub 子串
     * @param str 模板
     * @return strSub 是否是 str 的子串
     */
    private boolean isSubStr(String strSub, String str) {
        int idx1 = 0, idx2 = 0;
        while (idx1 < strSub.length() && idx2 < str.length()) {
            if (strSub.charAt(idx1) == str.charAt(idx2)) {
                idx1++;
            }
            idx2++;
        }
        return idx1 == strSub.length();
    }
}
