package com.datastructure;

import java.util.Arrays;

/**
 *
 *
 */
public class Text0706 {

    public static void main(String[] args) {

    }

}
class MyHashMap {

    int[] values = new int[1048576];

    public MyHashMap() {
        Arrays.fill(values, -1);
    }

    public void put(int key, int value) {
        values[key] = value;
    }

    public int get(int key) {
        return values[key];
    }

    public void remove(int key) {
        values[key] = -1;
    }
}
