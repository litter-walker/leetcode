package com.general;

/**
 * 模拟：一次遍历
 */
public class Text0393 {

    public boolean validUtf8(int[] data) {
        int[] bits = new int[8];
        for (int i = 1; i <= bits.length; i++) {
            bits[i - 1] = 1 << (bits.length - i);
        }
        for (int i = 0; i < data.length; i++) {
            // 多字节的情况
            if ((data[i] & bits[0]) != 0) {
                // 记录字节数量
                int count = 0;
                for (int bit : bits) {
                    if ((bit & data[i]) == 0) {
                        break;
                    }
                    count++;
                }
                // 表示为 10 开头的数字,或者字节大于4,不是UTF-8编码
                if (count == 1 || count > 4) {
                    return false;
                }
                count--;
                while (count-- > 0) {
                    i++;
                    // 判断是否为 10 开头
                    if (i >= data.length || (data[i] & bits[0]) != bits[0] || (data[i] & bits[1]) >= bits[1]) {
                        return false;
                    }
                }
            }

        }
        return true;
    }

}
