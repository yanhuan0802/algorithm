package com.yanhuan.dp;

/**
 * 最大子序列和
 *
 * @author YanHuan
 * @date 2021-02-14 22:16
 */
public class LeetCode53 {

    /**
     * 解法1. 动态规划  dp数组
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     * @param nums 数组
     * @return 和
     */
    public int maxSubArray(int[] nums) {
        //dp
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
