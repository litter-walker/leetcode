package com.general.text0380;

import java.util.*;

/**
 *
 */
@SuppressWarnings("all")
public class RandomizedSet {

    //  记录全部的值
    private final List<Integer> list;
    //  记录值的下标
    private final Map<Integer, Integer> map;
    //  随机对象
    private final Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        int idx = map.getOrDefault(val, -1);
        if (idx == -1) {
            return false;
        }
        int lastIdx = list.size() - 1;
        list.set(idx, list.get(lastIdx));
        map.put(val, idx);
        list.remove(lastIdx);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

}
