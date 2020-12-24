package com.yanhuan.dynamic.programming;

/**
 * 斐波那契数列
 *
 * @author YanHuan
 * @date 2020-12-24 22:26
 */
public class FibonacciSequence {

    /**
     * 解法1：暴力递归
     * <p>
     * 时间复杂度：O(2^n)
     *
     * @param n 序号
     * @return 值
     */
    int fib(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 解法2：带备忘录的递归法（自顶向下）
     * 时间复杂度：O(n)
     *
     * @param n 序号
     * @return 值
     */
    int fib2(int n) {
        if (n < 1) {
            return 0;
        }
        int[] memo = new int[n + 1];
        return helper(memo, n);
    }

    private int helper(int[] memo, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        //备忘录中记住的直接返回
        if (memo[0] != 0) {
            return memo[n];
        }
        return helper(memo, n - 1) + helper(memo, n - 2);
    }

    /**
     * 解法3：dp数组的迭代解法（自底向上）
     * 时间复杂度：O(n)
     *
     * @param n 序号
     * @return 值
     */
    int fib3(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
