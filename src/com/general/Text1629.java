package com.general;

import java.util.Arrays;

public class Text1629 {

    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxTime = releaseTimes[0];
        char maxChar = keysPressed.charAt(0);
        for (int i = 1; i < releaseTimes.length; i++) {
            int newTime = releaseTimes[i] - releaseTimes[i - 1];

            char newChar = keysPressed.charAt(i);
            if(newTime > maxTime ||
                    (newTime == maxTime && newChar > maxChar)) {
                maxTime = newTime;
                maxChar = newChar;
            }
        }
        return maxChar;
    }

    public static void main(String[] args) {

        int[] releaseTimes = {9,29,49,50};
        String keysPressed = "cbcd";
        System.out.println("releaseTimes = " + Arrays.toString(releaseTimes));
        System.out.println("keysPressed = " + keysPressed);

        System.out.println("slowestKey(releaseTimes, keysPressed) = " + slowestKey(releaseTimes, keysPressed));

    }
}
