package com.general;

/**
 * 遍历
 */
public class Text0468 {

    public String validIPAddress(String queryIP) {
        if (isIPv4(queryIP)) {
            return "IPv4";
        }
        if (isIPv6(queryIP)) {
            return "IPv6";
        }
        return "Neither";
    }

    private boolean isIPv4(String s) {
        // 先单独划分为 x
        String[] xArr = s.split("\\.", -1);
        // 判断 x 是否有 4 个
        if (xArr.length != 4) {
            return false;
        }
        // 遍历每个 x
        for (String x : xArr) {
            int n = x.length();
            // 判断每个 x 是否有，前导 0
            if (n > 3 || n < 1 || (n != 1 && x.charAt(0) == '0')) {
                return false;
            }
            // 判断每个 x 的值是否为 0 <= Integer.valueOf(x) <= 255
            int num = 0;
            for (int i = 0; i < n; i++) {
                char ch = x.charAt(i);
                if (!Character.isDigit(ch)) {
                    return false;
                }
                num *= 10;
                num += (ch - '0');
            }
            if (num < 0 || num > 255) {
                return false;
            }
        }
        return true;
    }

    private boolean isIPv6(String s) {
        // 先单独划分为 x
        String[] xArr = s.split(":", -1);
        // 判断 x 是否有 4 个
        if (xArr.length != 8) {
            return false;
        }
        // 遍历每个 x
        for (String x : xArr) {
            int n = x.length();
            // 判断每个 x 的长度, 1 <= n <= 4
            if (n < 1 || n > 4) {
                return false;
            }
            // 判断每个字符，是否符合要求
            //  数字 或者 a ~ f 或者 A ~ F
            for (int i = 0; i < n; i++) {
                char ch = x.charAt(i);
                if (!Character.isDigit(ch) &&
                        !(ch >= 'a' && ch <= 'f') &&
                        !(ch >= 'A' && ch <= 'F')) {
                    return false;
                }
            }
        }
        return true;
    }
}
