package com.util;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StockPrice {

    private Map<Integer, Integer> map;
    private TreeMap<Integer, Integer> treeMap;
    private Integer curTime;

    public StockPrice() {
        this.curTime = Integer.MIN_VALUE;
        this.map = new HashMap<>();
        this.treeMap = new TreeMap<>();
    }
    public void update(int timestamp, int price) {
        this.curTime = Math.max(this.curTime, timestamp);
        if (this.map.containsKey(timestamp)) {
            Integer oldPrice = this.map.get(timestamp);
            int count = this.treeMap.get(oldPrice) - 1;
            if (count == 0) {
                this.treeMap.remove(oldPrice);
            } else {
                this.treeMap.put(oldPrice, count);
            }

        }
        this.map.put(timestamp, price);
        this.treeMap.put(price, this.treeMap.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return map.get(this.curTime);
    }

    public int maximum() {
        return treeMap.lastKey();
    }

    public int minimum() {
        return treeMap.firstKey();
    }

}
