package com.yanhuan.dynamic.programming;

import java.util.Arrays;

/**
 * 凑零钱问题
 *
 * @author YanHuan
 * @date 2020-12-27 20:28
 */
public class LeetCode322 {

    /**
     * 解法1 记忆化搜索
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

    /**
     * 解法2 动态规划
     * 时间复杂度：O(Sn) S是金额，n是面额数
     * 空间复杂度：O(S)，数组需要开长度为总金额S的空间
     *
     * @param coins  硬币面值
     * @param amount 金额数
     * @return 最少需要的硬币数
     */
    public int coinChange1(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);

        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
