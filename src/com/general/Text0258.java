package com.general;

/**
 * 模拟：时间O(log(n)),空间O(1)
 *
 * 扩展：可使用同于定理解决
 */
public class Text0258 {

    public int addDigits(int num) {
        while (num >= 10) {
            int temp = 0;
            while (num > 0) {
                temp += num % 10;
                num /= 10;
            }
            num = temp;
        }
        return num;
    }

    public static void main(String[] args) {
        int num = 38;
        System.out.println("num = " + num);
        System.out.println("new Text0258().addDigits(num) = " + new Text0258().addDigits(num));
    }
}
