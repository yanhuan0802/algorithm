package com.yanhuan.dynamic.programming;

/**
 * 爬楼梯问题
 *
 * @author YanHuan
 * @date 2020-12-29 22:43
 */
public class LeetCode70 {
    /**
     * dp数组循环 和斐波那契数列一样
     * <p>
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * @param n 阶梯
     * @return 结果
     */
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * dp数组循环 和斐波那契数列一样
     * <p>
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param n 阶梯
     * @return 结果
     */
    public int climbStairs2(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
