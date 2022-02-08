package com.general;

import java.util.*;

/**
 * 模拟：
 *  使用哈希表保存以下信息：
 *      斜率：0、不存在、1、-1的点
 *      0：可以使用Y保存X的Set，对应代码中的mapY
 *      不存在：与0相似；对应代码中的mapX
 *      1：使用 x-y 为key值（因为斜率为1的同一条直线，对应的 x-y 就是 截距的倒数），对应代码中的mapXY
 *      -1：使用 x+y 为key值 （因为斜率为1的同一条直线，对应的x-y就是截距的倒数）， 对应代码中的mapYX
 * 程序步骤：
 *  1、使用上面的方法将灯的信息存入 hashMap中；
 *  2、遍历查询点；查看是否有点在对应的直线上；
 *  3、每次将查询点周围的灯关掉（即将灯的信息从HashMap中去掉）
 *
 *  简单来说，这道题运用初中数学知识（正比例函数：y = kx + b）
 */
public class Text1001 {

    public static int[] gridIllumination(int n, int[][] lamps, int[][] queries) {

        int[][] dirs = new int[][]{
                {-1, 1}, {0, 1}, {1, 1},
                {-1, 0}, {0, 0}, {1, 0},
                {-1, -1}, {0, -1}, {1, -1}
        };

        int[] ansArray = new int[queries.length];

        // 分别是对应X、Y以及对角线（X - Y、X + Y）的map
        Map<Integer, Set<Integer>> mapX = new HashMap<>();
        Map<Integer, Set<Integer>> mapY = new HashMap<>();
        Map<Integer, Set<Integer>> mapXY = new HashMap<>();
        Map<Integer, Set<Integer>> mapYX = new HashMap<>();
        for (int[] lamp : lamps) {
            int x = lamp[0];
            int y = lamp[1];
            Set<Integer> set = mapX.getOrDefault(x, new HashSet<>());
            set.add(y);
            mapX.put(x, set);
            set = mapY.getOrDefault(y, new HashSet<>());
            set.add(x);
            mapY.put(y, set);
            set = mapXY.getOrDefault(x - y, new HashSet<>());
            set.add(x);
            mapXY.put(x - y, set);
            set = mapYX.getOrDefault(x + y, new HashSet<>());
            set.add(x);
            mapYX.put(x + y, set);

        }

        for (int i = 0; i < queries.length; i++) {
            int queryX = queries[i][0];
            int queryY = queries[i][1];
            if (mapX.containsKey(queryX) ||
                    mapY.containsKey(queryY) ||
                    mapXY.containsKey(queryX - queryY) ||
                    mapYX.containsKey(queryX + queryY)) {
                ansArray[i] = 1;
            }
            // 移除
            for (int[] dir : dirs) {
                int reX = queryX + dir[0], reY = queryY + dir[1];
                if (mapX.getOrDefault(reX, new HashSet<>()).contains(reY)) {
                    mapX.get(reX).remove(reY);
                    mapY.get(reY).remove(reX);
                    mapXY.get(reX - reY).remove(reX);
                    mapYX.get(reX + reY).remove(reX);
                    if (mapX.get(reX).size() == 0) {
                        mapX.remove(reX);
                    }
                    if (mapY.get(reY).size() == 0) {
                        mapY.remove(reY);
                    }
                    if (mapXY.get(reX - reY).size() == 0) {
                        mapXY.remove(reX - reY);
                    }
                    if (mapYX.get(reX + reY).size() == 0) {
                        mapYX.remove(reX + reY);
                    }
                }
            }
        }
        return ansArray;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] lamps = {{1, 1}}, queries = {{2,0},{1,0}};
        System.out.println("gridIllumination(n, lamps, queries) = " + Arrays.toString(gridIllumination(n, lamps, queries)));
    }

}
