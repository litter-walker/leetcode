package com.general;

import com.util.StockPrice;

/**
 * 解题思路：
 *  使用Map保存数据：时间和价格；
 */
public class Text2034 {

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1, 10); // 时间戳为 [1] ，对应的股票价格为 [10] 。
        stockPrice.update(2, 5);  // 时间戳为 [1,2] ，对应的股票价格为 [10,5] 。
        System.out.println("stockPrice.current() = " + stockPrice.current());
        System.out.println("stockPrice.maximum() = " + stockPrice.maximum());
        stockPrice.update(1, 3);  // 之前时间戳为 1 的价格错误，价格更新为 3 。
        // 时间戳为 [1,2] ，对应股票价格为 [3,5] 。
        System.out.println("stockPrice.maximum() = " + stockPrice.maximum());
        stockPrice.update(4, 2);  // 时间戳为 [1,2,4] ，对应价格为 [3,5,2] 。
        System.out.println("stockPrice.minimum() = " + stockPrice.minimum());
    }
}
