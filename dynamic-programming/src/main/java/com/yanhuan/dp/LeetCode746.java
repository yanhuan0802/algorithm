package com.yanhuan.dp;

/**
 * 使用最小花费爬楼梯
 *
 * @author YanHuan
 * @date 2021-03-07 16:52
 */
public class LeetCode746 {
    /**
     * 解法1  动态规划
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * 两种方式到达：
     * 1.先踏上第 i-2级台阶，然后直接两步达到第i级台阶  dp[i-2]+cost[i]
     * 2.先踏上i-1及台阶，然后再一步达到第i级台阶  dp[i-1]+cost[i]
     * <p>
     * dp[i] =min(dp[i-2],dp[i-1])+cost[i];
     *
     * @param cost 数组
     * @return 最小花费
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
        }
        return Math.min(dp[cost.length - 2], dp[cost.length - 1]);
    }

    /**
     * 解法2  动态规划  在原数组操作
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * 两种方式到达：
     * 1.先踏上第 i-2级台阶，然后直接两步达到第i级台阶  dp[i-2]+cost[i]
     * 2.先踏上i-1及台阶，然后再一步达到第i级台阶  dp[i-1]+cost[i]
     * <p>
     * dp[i] =min(dp[i-2],dp[i-1])+cost[i];
     *
     * @param cost 数组
     * @return 最小花费
     */
    public int minCostClimbingStairs1(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i - 2], cost[i - 1]);
        }
        return Math.min(cost[cost.length - 2], cost[cost.length - 1]);
    }

}
