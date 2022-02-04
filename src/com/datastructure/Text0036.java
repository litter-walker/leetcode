package com.datastructure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 简单模拟
 */
public class Text0036 {

    public static boolean isValidSudoku(char[][] board) {
        int n = 9;
        // 规则1
        for (char[] row : board) {
            Set<Character> set = new HashSet<>();
            for (char c : row) {
                if (c != '.') {
                    boolean state = set.add(c);
                    if (!state) {
                        return false;
                    }
                }
            }
        }
        // 规则2
        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                // j 表示行，i表示列
                if (board[j][i] != '.') {
                    boolean state = set.add(board[j][i]);
                    if (!state) {
                        return false;
                    }
                }
            }
        }
        // 规则3
        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                // 表示第i个小九宫格的第j个格子;
                int x = (i / 3 * 3) + (j / 3);
                int y = (i % 3 * 3) + (j % 3);
                if (board[x][y] != '.') {
                    boolean state = set.add(board[x][y]);
                    if (!state) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board =
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println("board = " + Arrays.deepToString(board));
        System.out.println("isValidSudoku(board) = " + isValidSudoku(board));
    }

}