package com.general;

/**
 *  正难反易
 */
public class Text0780 {

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx == sx && ty == sy) {
                return true;
            }
            if (tx < ty) {
                // ty -= tx; 常规情况下，每次减小的会有可能超时，应该为倍数相减
                // ty %= tx; 单独倍数相减有可能， 跳过正确答案，因此应该过滤
                if (tx == sx) {
                    return (ty - sy) % tx == 0;
                }
                ty %= tx;
            } else {
                // tx -= ty;
                // tx %= ty;
                if (ty == sy) {
                    return (tx - sx) % ty == 0;
                }
                tx %= ty;
            }
        }
        return false;
    }

}
