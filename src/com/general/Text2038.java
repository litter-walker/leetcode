package com.general;

/**
 * 贪心
 */
public class Text2038 {

    public boolean winnerOfGame(String colors) {
        int countA = 0, countB = 0;
        char[] arrayColors = colors.toCharArray();
        for (int i = 1; i < arrayColors.length - 1; i++) {
            if (arrayColors[i - 1] == 'A' && arrayColors[i] == 'A' && arrayColors[i + 1] == 'A') {
                countA++;
            } else if (arrayColors[i - 1] == 'B' && arrayColors[i] == 'B' && arrayColors[i + 1] == 'B') {
                countB++;
            }
        }
        return countA > countB;
    }

}
