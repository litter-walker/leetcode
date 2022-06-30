package com.general.text1175;

/**
 * 质数判断
 */
public class Solution {
    private static final int MOD = (int)(1e9 + 7);
    public int numPrimeArrangements(int n) {
        int primeCount = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                primeCount++;
            }
        }
        return (int)(fact(primeCount) * fact(n - primeCount) % MOD);
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private long fact(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res = res * i % MOD;
        }
        return res;
    }
}
