package com.general;

/**
 * 贪心算法：每次选可取的最大值
 */
public class Text1405 {

    public static String longestDiverseString(int a, int b, int c) {

        StringBuilder ansStr = new StringBuilder();
        char[] preChar = new char[]{0, 1};
        while (a > 0 || b > 0 || c > 0) {
            char addChar = ' ';
            int maxNum = 0;
            if (a > maxNum && (preChar[0] != 'a' || preChar[1] != 'a')) {
                addChar = 'a';
                maxNum = a;
            }
            if (b > maxNum && (preChar[0] != 'b' || preChar[1] != 'b')) {
                addChar = 'b';
                maxNum = b;
            }
            if (c > maxNum && (preChar[0] != 'c' || preChar[1] != 'c')) {
                addChar = 'c';
            }
            switch (addChar) {
                case 'a':
                    a--;
                    break;
                case 'b':
                    b--;
                    break;
                case 'c':
                    c--;
            }
            if (addChar == ' ') {
                break;
            }
            preChar[0] = preChar[1];
            preChar[1] = addChar;
            ansStr.append(addChar);
        }
        return ansStr.toString();
    }

    public static void main(String[] args) {
        int a = 7, b = 1, c = 0;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("longestDiverseString(a, b ,c) = " + longestDiverseString(a, b, c));

    }

}
