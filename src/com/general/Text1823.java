package com.general;

/**
 * 正难反易-DP                                                                                        <br/>
 *  可以看作每次去掉一个人的时候，将规模减小1；                                                              <br/>
 *  假设 n 个人，间隔k去掉一个人时，最后获胜为 f(n, k); (这里的 f(n, k) 的区间为 [0, n - 1] )                  <br/>
 *  那么 n - 1 个人时，为 f(n - 1, k);                                                                  <br/>
 *  ···                                                                                              <br/>
 *  当 n = 1 时， f(1, k) = 1;                                                                        <br/>
 *                                                                                                   <br/>
 *  可以看出规模可以由 n -> n - 1 -> ... -> 1;                                                           <br/>
 *  那么，最后当规模为 1 时，获胜的应该为 1 ~ n 规模获胜的人，但是每个规模的开始都有一个偏移量；                     <br/>
 *  根据上面的推论可以得出，f(2, k) = (f(1, k) + 偏移量) % 2; (最后取余 2 避免结果超过 2);                     <br/>
 *  有题目可知，偏移量 = k                                                                               <br/>
 *  继续同理可以得出:                                                                                    <br/>
 *      f(3, k) = (f(2, k) + k) % 3;                                                                  <br/>
 *      f(4, k) = (f(3, k) + k) % 4;                                                                  <br/>
 *      ···                                                                                           <br/>
 *      f(n, k) = (f(n - 1, k) + k) % n;                                                              <br/>
 */
public class Text1823 {
    public int findTheWinner(int n, int k) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + k) % i;
        }
        return ans + 1;
    }
}
