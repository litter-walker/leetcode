package com.general;

/**
 * 解题思路：
 *  简单模拟
 */
public class Text0537 {
    public String complexNumberMultiply(String num1, String num2) {
        // a, b 表示num1和num2 的实部和虚部
        int[] a = new int[2], b = new int[2], ans = new int[2];
        a[0] = Integer.parseInt(num1.split("\\+")[0]);
        a[1] = Integer.parseInt(num1.split("(\\+)|i")[1]);
        b[0] = Integer.parseInt(num2.split("\\+")[0]);
        b[1] = Integer.parseInt(num2.split("(\\+)|i")[1]);
        // 计算
        ans[0] = a[0] * b[0] - a[1] * b[1];
        ans[1] = a[0] * b[1] + a[1] * b[0];
        return ans[0] + "+" + ans[1] + "i";
    }

    public static void main(String[] args) {
        String num1 = "1+-1i", num2 = "1+-1i";
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        Text0537 text0537 = new Text0537();
        System.out.println("text0537.complexNumberMultiply(num1, num2) = " + text0537.complexNumberMultiply(num1, num2));
    }
}
