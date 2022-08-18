package com.general.text1656;

import java.util.ArrayList;
import java.util.List;

/*
    模拟
 */
public class OrderedStream {

    private int n;
    private String[] strs;
    private int ptr;

    public OrderedStream(int n) {
        this.n = n;
        this.strs = new String[n + 1];
        this.ptr = 1;
    }

    public List<String> insert(int idKey, String value) {
        strs[idKey] = value;
        List<String> res = new ArrayList<>();
        while (ptr <= n && strs[ptr] != null) {
            res.add(strs[ptr]);
            ptr++;
        }
        return res;
    }
}
