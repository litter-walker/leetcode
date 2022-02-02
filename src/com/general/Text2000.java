package com.general;

/**
 * 1、查找字符出现位置；
 * 2、将前面的字符进行交换；
 */
public class Text2000 {

    public static String reversePrefix(String word, char ch) {
        int idxCh = word.indexOf(ch);
        if (idxCh == -1) {
            return word;
        }
        StringBuilder ansStrBd = new StringBuilder(word.substring(0, idxCh + 1));
        ansStrBd = ansStrBd.reverse().append(word.substring(idxCh + 1));
        return ansStrBd.toString();

    }

    public static void main(String[] args) {
        String word = "abcdefd";
        char ch = 'd';
        System.out.println("word = " + word);
        System.out.println("ch = " + ch);
        System.out.println("reversePrefix(word, ch) = " + reversePrefix(word, ch));
    }

}
