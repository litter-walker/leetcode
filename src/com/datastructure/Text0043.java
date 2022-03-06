package com.datastructure;

/**
 * 模拟
 */
public class Text0043 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        // 表示中间的积
        String[] temps = new String[num1.length()];
        for (int i = 0; i < num1.length(); i++) {
            temps[i] = mul(num2, num1.charAt(num1.length() - 1 - i), i);
        }
        String ans = "";
        for (String temp : temps) {
            ans = add(ans, temp);
        }
        return ans;
    }

    /**
     * 计算 一个数乘以一个一位数字
     *
     * @param num1      数
     * @param ch        一位数字
     * @param zeroCount 末尾添加多少个0
     * @return 积
     */
    private String mul(String num1, char ch, int zeroCount) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < zeroCount; i++) {
            ans.append(0);
        }
        int next = 0;
        for (int i = 0; i < num1.length(); i++) {
            int a = num1.charAt(num1.length() - 1 - i) - '0';
            a *= (ch - '0');
            a += next;
            ans.append(a % 10);
            next = a / 10;
        }
        if (next != 0) {
            ans.append(next);
        }
        return ans.reverse().toString();
    }

    /**
     * 计算两个数的和
     *
     * @param num1 加数
     * @param num2 加数
     * @return 和
     */
    private String add(String num1, String num2) {
        if (num1.length() < num2.length()) {
            return add(num2, num1);
        }
        StringBuilder ans = new StringBuilder();
        int next = 0;
        for (int i = 0; i < num1.length(); i++) {
            int a = num1.charAt(num1.length() - 1 - i) - '0';
            int b = 0;
            if (i < num2.length()) {
                b = num2.charAt(num2.length() - 1 - i) - '0';
            }
            ans.append((a + b + next) % 10);
            next = (a + b + next) / 10;
        }
        if (next != 0) {
            ans.append(next);
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "123", num2 = "456";
        System.out.println("new Text0043().multiply(num1, num2) = " + new Text0043().multiply(num1, num2));
    }
}
