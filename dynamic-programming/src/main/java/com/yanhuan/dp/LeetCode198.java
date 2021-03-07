package com.yanhuan.dp;

/**
 * 打家劫舍
 *
 * @author YanHuan
 * @date 2021-02-15 13:17
 */
public class LeetCode198 {

    /**
     * 解法1. 动态规划  二维dp数组
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums 数组
     * @return 结果
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        //二维数组 第一层表示当前索引  第二层表示 0不偷  1偷
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            //当前层不偷
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            //当前层偷
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }


    /**
     * 解法2. 动态规划  二维dp数组
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums 数组
     * @return 结果
     */
    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            //取上一层 和  当前层加上两层  的最大值
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }


    /**
     * 解法3. 动态规划  滚动
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums 数组
     * @return 结果
     */
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int first = nums[0], second = Math.max(nums[0], nums[1]);

        //滚动数组
        for (int i = 2; i < n; i++) {
            int tmp = Math.max(second, first + nums[i]);
            first = second;
            second = tmp;
        }

        return second;
    }
}
