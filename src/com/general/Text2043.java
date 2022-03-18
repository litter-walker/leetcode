package com.general;

/**
 * 简单模拟
 */
public class Text2043 {


}

class Bank {

    private long[] balance;

    public Bank(long[] balance) {
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (visitedAc(account1) &&
                visitedAc(account2) &&
                money <= balance[account1 - 1]) {
            balance[account1 - 1] -= money;
            balance[account2 - 1] += money;
            return true;
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        if (visitedAc(account)) {
            balance[account - 1] += money;
            return true;
        }
        return false;
    }

    public boolean withdraw(int account, long money) {
        if (visitedAc(account) && money <= balance[account - 1]) {
            balance[account - 1] -= money;
            return true;
        }
        return false;
    }

    /**
     * 判断是否存在账户
     * @param account 账户编号
     * @return 账户存在，返回true；否则，返回false
     */
    private boolean visitedAc(int account) {
        return account >= 1 && account <= balance.length;
    }

}
