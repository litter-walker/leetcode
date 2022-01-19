package com.week02;

import java.util.HashMap;
import java.util.Map;

public class day01 {

    public static String getHint(String secret, String guess) {

        Map<Character, Integer> maps = new HashMap<>();
        Map<Character, Integer> mapg = new HashMap<>();

        int bulls = 0, cows = 0;

        for (int i = 0; i < secret.length(); i++) {
            char cs = secret.charAt(i);
            char cg = guess.charAt(i);
            if (cs == cg) {
                bulls++;
            } else {
                maps.put(cs, maps.getOrDefault(cs, 0) + 1);
                mapg.put(cg, mapg.getOrDefault(cg, 0) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : mapg.entrySet()) {
            char key = entry.getKey();
            int valueg = entry.getValue();
            int values = maps.getOrDefault(key, 0);
            cows += Math.min(valueg, values);
        }
        return bulls + "A" + cows + "B";
    }


    public static void main(String[] args) {

        String secret = "1", guess = "1";

        System.out.println(getHint(secret, guess));

    }

}
