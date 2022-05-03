package com.general;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟-排序
 */
public class Text0937 {

    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> numLogs = new ArrayList<>();
        for (String log : logs) {
            int idx = log.indexOf(' ');
            if (Character.isDigit(log.charAt(idx + 1))) {
                numLogs.add(log);
            } else {
                letterLogs.add(log);
            }
        }
        letterLogs.sort((a, b) -> {
            int idx1 = a.indexOf(' ');
            int idx2 = b.indexOf(' ');
            int compareTo = a.substring(idx1 + 1).compareTo(b.substring(idx2 + 1));
            if (compareTo == 0) {
                return a.substring(0, idx1).compareTo(b.substring(0, idx2));
            }
            return compareTo;
        });
        letterLogs.addAll(numLogs);
        return letterLogs.toArray(new String[0]);
    }

}
