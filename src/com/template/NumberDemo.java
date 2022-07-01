package com.template;

import java.util.regex.Pattern;

/**
 * 数字相关 Demo
 */
public class NumberDemo {

    /**
     * 通过正则表达式判断字符串是否为 数字(包含小数)
     *
     * @param str 判断字符串
     * @return 判断结果
     */
    public static boolean isNumber(String str) {
        // 通过Matcher进行字符串匹配
        Pattern pattern = Pattern.compile("^[-+]?[\\d]+(\\.[\\d]+)?");
        // 如果正则匹配通过 m.matches() 方法返回 true ，反之 false
        return pattern.matcher(str).matches();
    }

    /**
     * 判断字符串是否为 整数
     *
     * @param str 判断字符串
     * @return 判断结果
     */
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-+]?[\\d]+$");
        return pattern.matcher(str).matches();
    }
}
