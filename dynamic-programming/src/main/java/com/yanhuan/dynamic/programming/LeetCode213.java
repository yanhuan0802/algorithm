package com.yanhuan.dynamic.programming;

/**
 * 打家劫舍2
 *
 * @author YanHuan
 * @date 2021-02-15 14:07
 */
public class LeetCode213 {
    /**
     * 解法1.  动态规划  dp数组
     * <p>
     * 思路：第一个不能偷或者最后一个不能偷，转换为两个单排列，即转化为了打家劫舍问题
     * <p>
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * @param nums 数组
     * @return 金额数
     */
    public int rob(int[] nums) {
        //特判
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int noLast = rob(nums, 0, nums.length - 2);
        int noFirst = rob(nums, 1, nums.length - 1);
        return Math.max(noLast, noFirst);
    }

    private int rob(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[end];
    }


    /**
     * 解法2.  动态规划  滚动数组
     * <p>
     * 思路：第一个不能偷或者最后一个不能偷，转换为两个单排列，即转化为了打家劫舍问题
     * <p>
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param nums 数组
     * @return 金额数
     */
    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int noLast = rob1(nums, 0, nums.length - 2);
        int noFirst = rob1(nums, 1, nums.length - 1);
        return Math.max(noFirst, noLast);
    }

    private int rob1(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int tmp = Math.max(second, first + nums[i]);
            first = second;
            second = tmp;
        }
        return second;
    }
}
