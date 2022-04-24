package com.general;

/**
 * 简单模拟
 */
public class Text0824 {
    public String toGoatLatin(String sentence) {
        int n = sentence.length();
        StringBuilder ans = new StringBuilder();
        StringBuilder as = new StringBuilder("a");
        for (int head = 0; head < n; ++head) {
            int last = head + 1;
            while (last < n && sentence.charAt(last) != ' ') ++last;
            if ("aeiouAEIOU".indexOf(sentence.charAt(head)) >= 0) {
                ans.append(sentence, head, last);
            } else {
                ans.append(sentence, head + 1, last)
                        .append(sentence.charAt(head));
            }
            ans.append("ma")
                    .append(as);
            as.append('a');
            if (last < n) {
                ans.append(' ');
            }
            head = last;
        }
        return ans.toString();
    }
}
