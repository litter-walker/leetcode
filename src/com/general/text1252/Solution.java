package com.general.text1252;

/**
 * 计数
 */
public class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int[] indice : indices) {
            rows[indice[0]]++;
            cols[indice[1]]++;
        }
        int evenR = m, evenC = n;
        for (int row : rows) {
            if (row % 2 == 1) {
                evenR--;
            }
        }
        for (int col : cols) {
            if (col % 2 == 1) {
                evenC--;
            }
        }
        return evenR * (n - evenC) + evenC * (m - evenR);
    }
}
