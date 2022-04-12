package com.general;

/**
 *  简单模拟
 */
public class Text0806 {
    public int[] numberOfLines(int[] widths, String s) {
        int row = 1, col = 0;
        for (int i = 0; i < s.length(); i++) {
            col += widths[s.charAt(i) - 'a'];
            if (col > 100) {
                row++;
                col = widths[s.charAt(i) - 'a'];
            }
        }
        return new int[]{row, col};
    }
}
