package com.general;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * 两个端点均存在可达点数量大于n(n-1)/2; 其中n表示封锁点数量;
 */
public class Text1036 {

    // 保存边界最大
    private static int E6 = (int) 1e6;
    // 限制点的最大数量
    private int MAX_COUNT;
    // 保存封锁列表信息
    private Set<Long> blockedSet = new HashSet<Long>();

    // 封锁列表hash值；
    private long hashCode(int x, int y) {
        return (long)x * E6 + y;
    }

    // 判断点是否可通过；
    private boolean canPass(int x, int y) {
        if (x < 0 || x >= E6 ||
                y < 0 || y >= E6 ||
                blockedSet.contains(hashCode(x, y))) {
            return false;
        }
        return true;
    }

    /**
     * 进行BFS遍历,判断可达的点是否大于数量限制数量；
     * @param s 起点;
     * @param t 终点;
     */
    private boolean BFS(int[] s, int[] t) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(s);
        // 记录访问过的点;
        Set<Long> visited = new HashSet<>();
        visited.add(hashCode(s[0], s[1]));
        int visitedCount = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            // 将上下左右四个点入队
            int[] preSet = {0, 1, 0, -1, 0};
            for (int i = 0; i < 4; i++) {
                int preX = poll[0] + preSet[i];
                int preY = poll[1] + preSet[i + 1];
                if (!visited.contains(hashCode(preX, preY))
                        && canPass(preX, preY)) {
                    queue.offer(new int[]{preX, preY});
                }
                if(preX == t[0] && preY == t[1]) {
                    return true;
                }
                visited.add(hashCode(preX, preY));
            }

            visitedCount++;
            if(visitedCount > MAX_COUNT) {
                return true;
            }
        }
        return false;
    }

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {

        // 限制数量
        int n = blocked.length;
        MAX_COUNT = n * (n - 1) / 2;

        for (int[] b : blocked) {
            blockedSet.add(hashCode(b[0], b[1]));
        }

        return BFS(source, target) && BFS(target, source);
    }


    public static void main(String[] args) {
        int[][] blocked = {
                {100059,100063},{100060,100064},{100061,100065},{100062,100066},{100063,100067},{100064,100068},{100065,100069},{100066,100070},{100067,100071},{100068,100072},{100069,100073},{100070,100074},{100071,100075},{100072,100076},{100073,100077},{100074,100078},{100075,100079},{100076,100080},{100077,100081},{100078,100082},{100079,100083},{100080,100082},{100081,100081},{100082,100080},{100083,100079},{100084,100078},{100085,100077},{100086,100076},{100087,100075},{100088,100074},{100089,100073},{100090,100072},{100091,100071},{100092,100070},{100093,100069},{100094,100068},{100095,100067},{100096,100066},{100097,100065},{100098,100064},{100099,100063},{100098,100062},{100097,100061},{100096,100060},{100095,100059},{100094,100058},{100093,100057},{100092,100056},{100091,100055},{100090,100054},{100089,100053},{100088,100052},{100087,100051},{100086,100050},{100085,100049},{100084,100048},{100083,100047},{100082,100046},{100081,100045},{100080,100044},{100079,100043},{100078,100044},{100077,100045},{100076,100046},{100075,100047},{100074,100048},{100073,100049},{100072,100050},{100071,100051},{100070,100052},{100069,100053},{100068,100054},{100067,100055},{100066,100056},{100065,100057},{100064,100058},{100063,100059},{100062,100060},{100061,100061},{100060,100062}
        };
        int[] source = {100079,100063};
        int[] target = {999948,999967};
        int[][] xx = new int[100][100];
        for (int[] ints : blocked) {
            xx[ints[0] - 100000][ints[1] - 100000] = 1;
        }
        xx[source[0] - 100000][source[1] - 100000] = 2;

        int xxs = 0;
        for (int[] ints : xx) {
            String str = "";
            for (int i = 0; i < ints.length; i++) {
                if(ints[i] == 1) {
                    str += ints[i];
                } else {
                    str += " ";
                }
            }
            System.out.println(str);
        }
        Text1036 text1036 = new Text1036();
        if(text1036.isEscapePossible(blocked, source, target)) {
            System.out.println("可达");
        } else {
            System.out.println("不可达");
        }
        System.out.println(E6);

    }
}
