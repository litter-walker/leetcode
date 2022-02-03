package com.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * 简单模拟
 */
public class Text0118 {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ansList = new ArrayList<>();
        ansList.add(new ArrayList<>() {{
            add(1);
        }});
        for (int i = 1; i < numRows; i++) {
            List<Integer> curList = new ArrayList<>();
            curList.add(1);
            for (int j = 1; j < i; j++) {
                List<Integer> preList = ansList.get(i - 1);
                curList.add(preList.get(j - 1) + preList.get(j));
            }
            curList.add(1);
            ansList.add(curList);
        }
        return ansList;
    }

    public static void main(String[] args) {
        int numRows = 5;
        System.out.println("numRows = " + numRows);
        System.out.println("generate(numRows) = " + generate(numRows));
    }

}
