package com.yanhuan.dynamic.programming;

/**
 * 凑零钱问题
 *
 * @author YanHuan
 * @date 2020-12-27 20:28
 */
public class LeetCode322 {

    /**
     * 解法1 动态规划（自上而下）
     *
     * @param coins  硬币面值
     * @param amount 金额数
     * @return 最少需要的硬币数
     */
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        count[rem - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return count[rem - 1];
    }
}
