package com.general;


import java.util.Arrays;

/**
 * 暴力枚举:
 * 假设有 m 个请求， 则有 2 ^ m 种方案；
 * 对于第 i 种方案，i的二进制的第 j 位，以表示第 i 种方案的 第 j 个 请求是否选取
 */
public class Text1601 {

    public int maximumRequests(int n, int[][] requests) {
        int ans = 0;
        // 表示每栋楼的变化数量
        int[] counts = new int[n];
        for (int i = 0; i < 1 << requests.length; i++) {
            Arrays.fill(counts, 0);
            if (Integer.bitCount(i) < ans) {
                continue;
            }
            for (int j = 0; j < requests.length; j++) {
                if (((i >> j) & 1) == 1) {
                    counts[requests[j][0]]--;
                    counts[requests[j][1]]++;
                }
            }
            boolean flag = false;
            for (int count : counts) {
                if (count != 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                ans = Math.max(ans, Integer.bitCount(i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] requests = {{1,2},{1,2},{2,2},{0,2},{2,1},{1,1},{1,2}};
        System.out.println("requests = " + Arrays.deepToString(requests));
        System.out.println("new Text1601().maximumRequests(requests) = " + new Text1601().maximumRequests(3, requests));
    }

}

