package com.general;

/**
 * 遍历+栈+前缀和
 */
public class Text0388 {
    public int lengthLongestPath(String input) {
        int ans = 0;

        // 避免最后一个无法记录
        input = input + '\n';

        int n = input.length();
        int[] stack = new int[n];
        int top = 0;
        int idxHead = 0;
        boolean isFile = false;
        for (int i = 0; i < n; i++) {
            int ch = input.charAt(i);
            switch (ch) {
                case '\n':
                    if (isFile) {
                        // 不要忘记 加上 路径中的 '/'的数量，刚好等于 top
                        ans = Math.max(stack[top] + (i - idxHead) + top, ans);
                    } else {
                        stack[top + 1] = stack[top] + (i - idxHead);
                    }
                    // 进入下一个路径前，初始化
                    idxHead = i + 1;
                    isFile = false;
                    top = 0;
                    break;
                case '.':
                    isFile = true;
                    break;
                case '\t':
                    top++;
                    idxHead = i + 1;
                    break;
            }
        }
        return ans;
    }

}
