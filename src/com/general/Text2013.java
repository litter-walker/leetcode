package com.general;

import java.util.HashMap;
import java.util.Map;

/**
 * 解题思路：
 *  使用二维数组，记录点的数量
 *  已知的点，与未知的点(a,b,c)构成正方形的数量为 a * b * c （数量的乘积）
 */
public class Text2013 {
    public static void main(String[] args) {
        DetectSquares detectSquares = new DetectSquares();

        detectSquares.add(new int[]{3, 10});
        detectSquares.add(new int[]{11, 2});
        detectSquares.add(new int[]{3, 2});
        int count = detectSquares.count(new int[]{11, 10});// 返回 1 。你可以选择：
        System.out.println("count = " + count); //   - 第一个，第二个，和第三个点
        count = detectSquares.count(new int[]{14, 8});  // 返回 0 。查询点无法与数据结构中的这些点构成正方形。
        System.out.println(count);
        detectSquares.add(new int[]{11, 2});    // 允许添加重复的点。
        count = detectSquares.count(new int[]{11, 10}); // 返回 2 。你可以选择：
        System.out.println("count = " + count);
        //   - 第一个，第二个，和第三个点
        //   - 第一个，第三个，和第四个点
    }
}
class DetectSquares {

    private Map<Integer, Map<Integer, Integer>> counts = new HashMap<>();

    public DetectSquares() {
    }

    public void add(int[] point) {
        Map<Integer, Integer> map = counts.getOrDefault(point[0], new HashMap<>());
        map.put(point[1], map.getOrDefault(point[1], 0) + 1);
        counts.put(point[0], map);
    }

    public int count(int[] point) {
        int ans = 0;
        Map<Integer, Integer> map = counts.getOrDefault(point[0], new HashMap<>());
        for (Integer y : map.keySet()) {
            if (y == point[1]) {
                continue;
            }
            int deltaY = point[1] - y;
            int cut1 = map.get(y);
            int[] axisX = new int[]{point[0] - deltaY, point[0] + deltaY};
            for (int x : axisX) {
                Map<Integer, Integer> newMap = counts.getOrDefault(x, new HashMap<>());
                int cut2 = newMap.getOrDefault(point[1], 0);
                int cut3 = newMap.getOrDefault(y, 0);
                ans += cut1 * cut2 * cut3;
            }

        }

        return ans;
    }
}
