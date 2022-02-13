package com.general;

/**
 * 哈希表
 */
public class Text1189 {

    public static int maxNumberOfBalloons(String text) {

        // 保存 'b','a','l','o','n'的数量（为后面计算简单，将所有字母，以单词的两倍计数）
        int[] letters = new int[5];

        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case 'b':
                    letters[0] += 2;
                    break;
                case 'a':
                    letters[1] += 2;
                    break;
                case 'l':
                    letters[2]++;
                    break;
                case 'o':
                    letters[3]++;
                    break;
                case 'n':
                    letters[4] += 2;
                    break;
            }
        }
        int minNum = Integer.MAX_VALUE;
        for (int letter : letters) {
            minNum = Math.min(minNum, letter / 2);
        }
        return minNum;
    }

    public static void main(String[] args) {
        String text = "leetcode";
        System.out.println("text = " + text);
        System.out.println("maxNumberOfBalloons(text) = " + maxNumberOfBalloons(text));
    }
}
