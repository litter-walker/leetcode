package com.general;


import java.util.regex.Pattern;

public class Text2047 {

    public static int countValidWords(String sentence) {
        int ans = 0;
        String pattern = "^([,.!]|[a-z]+(-[a-z]+)?[,.!]?)$";
        String[] tokens = sentence.split(" ");
        for (String token : tokens) {
            if (token.matches(pattern)) {
                ans++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        String sentence = "he bought 2 pencils, 3 erasers, and 1  pencil-sharpener.";
        System.out.println("countValidWords(sentence) = " + countValidWords(sentence));
    }
}
