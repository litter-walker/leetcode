package com.general;

/**
 * 分类考虑：
 * 1. 考虑将 n 的前半部分补齐；
 * 2. 当数据原本就是回文时，将前半部分 +1, -1; 再补齐，比较最大值；
 * 3. 长度为 1 时， 直接 -1
 * 特殊情况：(返回的位数有所改变)
 * 枚举所有的特殊情况；
 * 1. 整个数字为 10、100、1000、10000 时， -1；
 * 2. 整个数字为11、101、1001...时， -2;
 * 3. 整个数字为99，999，9999，....时， +2；
 */
public class Text0564 {

    public String nearestPalindromic(String n) {
        int len = n.length();
        long pw = (long) Math.pow(10, len - 1);
        long nLong = Long.parseLong(n);
        if (len == 1 || nLong == pw) { // 1
            return String.valueOf(nLong - 1);
        } else if (nLong - 1 == pw) { // 2
            return String.valueOf(nLong - 2);
        } else if (nLong + 1 == pw * 10) { // 3
            return String.valueOf(nLong + 2);
        }
        String leftStr = n.substring(0, (len + 1) / 2);
        long leftValue = Long.parseLong(leftStr);
        long upValue = replenishRight(leftValue + 1, len);
        long value = replenishRight(leftValue, len);
        long downValue = replenishRight(leftValue - 1, len);
        if (value == nLong) {
            return String.valueOf(upValue - nLong < nLong - downValue ? upValue: downValue);
        }
        if (upValue - nLong < Math.abs(value - nLong) && upValue - nLong < nLong - downValue) {
            return String.valueOf(upValue);
        } else if (Math.abs(value - nLong) < nLong - downValue) {
            return String.valueOf(value);
        } else {
            return String.valueOf(downValue);
        }
    }

    private long replenishRight(Long left, int len) {
        StringBuilder leftSb = new StringBuilder().append(left);
        StringBuilder rightSb = new StringBuilder(leftSb).reverse();
        if (leftSb.length() + rightSb.length() == len) {
            return Long.parseLong(leftSb.append(rightSb).toString());
        } else {
            return Long.parseLong(leftSb.append(rightSb.substring(1)).toString());
        }
    }

    public static void main(String[] args) {
        String n = "1283";
        System.out.println("n = " + n);
        System.out.println("new Text0564().nearestPalindromic(n) = " + new Text0564().nearestPalindromic(n));

    }
}
