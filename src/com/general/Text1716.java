package com.general;

/**
 * 等差数列
 */
public class Text1716 {

    public static int totalMoney(int n) {
        // 周数
        int weekCount = n / 7;
        /*
         * 每周比上周多7元
         * 该等比数列为：
         *  首项为(1 + 2 + 3 + 4 + 5 + 6 + 7)
         *  公差为7
         * 求前weekCount项和;
         */
        int a1 = 1 + 2 + 3 + 4 + 5 + 6 + 7;
        int d = 7;
        int sum = weekCount * a1 + weekCount * (weekCount - 1) * d / 2;
        /*
         * 最后一周的第一天为weekCount+1;
         * 同样视为以weekCount为首项, 1为公差的等差数列;
         */
        // 最后一周的天数;
        int OverDay = n % 7;
        sum += (weekCount + 1) * OverDay + OverDay * (OverDay - 1) / 2;
        return sum;
    }

    public static void main(String[] args) {
        int n = 10;

        System.out.println("n = " + n);
        System.out.println("totalMoney(n) = " + totalMoney(n));
    }
}
