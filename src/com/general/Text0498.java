package com.general;

/**
 * 解决方案：数学 + 模拟
 *  对角线可以看看成是， y = -x + k 的一条线
 *  可以得出 k = y + x;
 *  由此，可得 0 <= k <= (m - 1) + (n - 1)
 *  途中 k 每增加一次， 遍历方向就改变一次；那么可以 通过 奇偶 判断方向
 *  判断起点是上面还是下面，也通过 奇偶；
 *
 *  确定起点：可以通过 k 的值确定
 *
 */
public class Text0498 {

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        int[] ans = new int[m * n];
        int idx = 0;
        for (int k = 0; k <= (m - 1) + (n - 1); k++) {
            int delta, x, y;
            if (k % 2 == 0) {
                delta = -1;
                x = k >= m ? m - 1 : k;
                y = k - x;
            } else {
                delta = 1;
                y = k >= n ? n - 1 : k;
                x = k - y;
            }
            while (0 <= x && x < m && 0 <= y && y < n) {
                ans[idx++] = mat[x][y];
                x += delta;
                y -= delta;
            }
        }
        return ans;
    }
}
