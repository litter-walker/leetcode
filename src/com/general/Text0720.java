package com.general;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 哈希表
 */
public class Text0720 {

    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        String ans = "";
        for (String word : words) {
            if (word.length() < ans.length() || (word.length() == ans.length() && word.compareTo(ans) > 0)) {
                continue;
            }
            for (int r = word.length(); r > 0; r--) {
                if (!set.contains(word.substring(0, r))) {
                    break;
                }
                if (r == 1) {
                    ans = word;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"w","wo","wor","worl", "world"};
        System.out.println("new Text0720().longestWord(words) = " + new Text0720().longestWord(words));
    }

}
