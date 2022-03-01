package com.general;

/**
 * 找规律：简单模拟
 */
public class Text0006 {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder ansSb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += (numRows - 1) * 2) {
                ansSb.append(s.charAt(j));
                int r = j - i + (numRows - 1) * 2 - i;
                if (i != 0 && i != numRows - 1 && r < s.length()) {
                    ansSb.append(s.charAt(r));
                }
            }
        }
        return ansSb.toString();
    }

    public static void main(String[] args) {
        String s = "A";
        int numRows = 1;
        System.out.println("s = " + s);
        System.out.println("numRows = " + numRows);
        System.out.println("new Text0006().convert(s, numRows) = " + new Text0006().convert(s, numRows));
    }
}
