package com.general;

import java.util.HashSet;
import java.util.Set;

/**
 * 哈希表
 */
public class Text0929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            StringBuilder emailSb = new StringBuilder();
            // 遍历 字符串 得出本地名
            for (int i = 0; i < email.length(); i++) {
                char ch = email.charAt(i);
                if (ch == '+' || ch == '@') {
                    break;
                }
                if (ch == '.') {
                    continue;
                }
                emailSb.append(ch);
            }
            emailSb.append('@').append(email.split("@")[1]);
            set.add(emailSb.toString());
        }
        return set.size();
    }
}
