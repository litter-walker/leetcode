package com.general;

import java.util.HashSet;
import java.util.Set;

/**
 * 哈希表
 */
public class Text0804 {

    public int uniqueMorseRepresentations(String[] words) {
        String[] passwordTable = {
                ".-","-...","-.-.","-..",
                ".","..-.","--.","....",
                "..",".---","-.-",".-..",
                "--","-.","---",".--.",
                "--.-",".-.","...","-",
                "..-","...-",".--","-..-",
                "-.--","--.."
        };
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder password = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                password.append(passwordTable[word.charAt(i) - 'a']);
            }
            set.add(password.toString());
        }
        return set.size();
    }

}
